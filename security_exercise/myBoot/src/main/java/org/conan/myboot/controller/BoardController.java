package org.conan.myboot.controller;

import lombok.AllArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.conan.myboot.domain.BoardDTO;
import org.conan.myboot.domain.PageRequestDTO;
import org.conan.myboot.service.BoardService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Log4j2
@AllArgsConstructor
@Controller
public class BoardController {
    //    @Autowired
    private BoardService boardService;
    @GetMapping("/write")
    public void write(){
    }

    @GetMapping("/list")
    public void list(PageRequestDTO pageRequestDTO, Model model){
        log.info("list.............");
        //result에는 dtoList를 포함 pagination에 필요한 정보가 추가되어 있음
        model.addAttribute("result", boardService.getList(pageRequestDTO));
    }
    @PostMapping("/write")     //게시글 저장
    public String write(BoardDTO dto, RedirectAttributes rttr) {
        log.info("write :"+ dto);
        Long bno = boardService.write(dto);
//        log.
        rttr.addFlashAttribute("msg", bno);
        return "redirect:/board/list";
    }
    @GetMapping({"/read", "/modify"})
    public void read(@RequestParam("bno") Long bno, Model model) {
        log.info("/read");
//        model.addAttribute("board", boardService.read(bno));
    }
    @PostMapping( "/modify")
    public String modify(BoardDTO dto, RedirectAttributes rttr) {
        log.info("modify : "+dto);
//        if(boardService.modify(dto)) {
//            rttr.addFlashAttribute("result", "success");
//        }
        return "redirect:/board/list";
    }
    @PostMapping( "/remove")
    public String remove(@RequestParam("bno")Long bno,  RedirectAttributes rttr ) {
        log.info("remove.......:"+bno);
//        if(boardService.remove(bno)) {
//            rttr.addFlashAttribute("result", "success");
//        }
        return "redirect:/board/list";
    }
}