package org.conan.controller;

import lombok.AllArgsConstructor;
import org.conan.domain.Board;
import org.conan.service.BoardService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
//@Log4j
@RequestMapping("/board")
@AllArgsConstructor
public class BoardController {
    private BoardService boardService;

    @GetMapping("/list")
    public String list(Model model) {
        System.out.println("BoardController.list");
        model.addAttribute("bList", boardService.getList());
        return "/board/list";
    }

    @GetMapping("/write")
    public String register() {
        System.out.println("BoardController.register");
        return "/board/write";
    }

    @PostMapping("/write")
    public String register(Board board, RedirectAttributes rttr){
        System.out.println("write: " + board);
        boardService.write(board);
        rttr.addFlashAttribute("result", board.getBno());
        return "redirect:/board/list";
    }

    @GetMapping({"/read", "/modify"})
    public String read(@RequestParam("bno") Integer bno, Model model) {
        System.out.println("read");
        model.addAttribute("board", boardService.read(bno));
        return "/board/read";
    }

    @PostMapping("/modify")
    public String modify(Board board, RedirectAttributes rttr) {
        System.out.println("modify: " + board);
        if(boardService.modify(board)) {
            rttr.addFlashAttribute("result", "success");
        }
        return "redirect:/board/list";
    }

    @PostMapping("/remove")
    public String remove(@RequestParam("bno") Integer bno, RedirectAttributes rttr) {
        System.out.println("remove: " + bno);
        if(boardService.remove(bno)) {
            rttr.addFlashAttribute("result", "success");
        }
        return "redirect:/board/list";
    }


}
