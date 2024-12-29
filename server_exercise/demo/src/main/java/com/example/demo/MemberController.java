package com.example.demo;


import com.example.demo.vo.Members;
import jakarta.servlet.ServletConfig;
import jakarta.servlet.ServletContext;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;
import java.util.List;

@WebServlet("*.action")
public class MemberController extends HttpServlet {

    @Override
    public void init(ServletConfig config) throws ServletException {
        super.init(config);
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String uri = request.getRequestURI();
        System.out.println("uri = " + uri);
        String contextPath = request.getContextPath();
        System.out.println("contextPath = " + contextPath);
        String cmd = uri.substring(contextPath.length());
        System.out.println("cmd = " + cmd);

        if (cmd.equals("/member/login.action")) {
            System.out.println("login");
            System.out.println("==============================");
            login(request, response);
        } else if (cmd.equals("/member/join.action")) {
            System.out.println("join");
            System.out.println("==============================");
            insert(request, response);
        } else if (cmd.equals("/member/read.action")) {
            System.out.println("read");
            System.out.println("==============================");
            read(request, response);
        } else if (cmd.equals("/member/list.action")) {
            System.out.println("list");
            System.out.println("==============================");
            list(request, response);
        } else if (cmd.equals("/member/updateFrm.action")) {
            System.out.println("updateFrm");
            System.out.println("==============================");
            updateFrm(request, response);
        } else if (cmd.equals("/member/update.action")) {
            System.out.println("updateFrm");
            System.out.println("==============================");
            update(request, response);
        } else if (cmd.equals("/member/delete.action")) {
            System.out.println("delete");
            System.out.println("==============================");
            delete(request, response);
        }
    }

    private void insert(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        ServletContext application = request.getServletContext();
        MemberDAO dao = new MemberDAO(application);
        Members member = new Members();
        member.setUserId(request.getParameter("userId"));
        member.setUserPwd(request.getParameter("userPwd"));
        member.setUserName(request.getParameter("userName"));
        member.setEmail(request.getParameter("email"));
        int insert = dao.insert(member);
        System.out.println("insert = " + insert);
        list(request, response);
    }

    private void login(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        ServletContext application = request.getServletContext();
        MemberDAO dao = new MemberDAO(application);
        String userId = request.getParameter("userId");
        String userPwd = request.getParameter("userPwd");
        try {
            Members member = dao.getMember(userId);
            dao.close();
            if (member.getUserPwd().equals(userPwd)) {
                HttpSession session = request.getSession();
                session.setAttribute("loginId", request.getParameter("userId"));
                response.sendRedirect(request.getContextPath() + "/member/list.action");
            }
        } catch (Exception e) {
            request.getRequestDispatcher("/member/loginFrm.jsp").forward(request, response);
        }
    }

    private void read(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        ServletContext application = request.getServletContext();
        MemberDAO dao = new MemberDAO(application);
        Members member = dao.getMember(request.getParameter("id"));
        dao.close();
        request.setAttribute("member", member);
        request.getRequestDispatcher("/member/read.jsp").forward(request, response);
    }

    private void list(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        ServletContext application = request.getServletContext();
        MemberDAO dao = new MemberDAO(application);
        List<Members> mList = dao.getList();
        dao.close();
        request.setAttribute("mList", mList);
        request.getRequestDispatcher("/member/memberList.jsp").forward(request, response);
    }

    private void updateFrm(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        ServletContext application = request.getServletContext();
        MemberDAO dao = new MemberDAO(application);
        HttpSession session = request.getSession();
        Members member = dao.getMember((String) session.getAttribute("loginId"));
        dao.close();
        request.setAttribute("member", member);
        request.getRequestDispatcher("/member/updateFrm.jsp").forward(request, response);
    }

    private void update(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        ServletContext application = request.getServletContext();
        MemberDAO dao = new MemberDAO(application);
        HttpSession session = request.getSession();
        Members member = dao.getMember((String) session.getAttribute("loginId"));
        member.setUserPwd(request.getParameter("userPwd"));
        member.setUserName(request.getParameter("userName"));
        member.setEmail(request.getParameter("email"));
        int update = dao.update(member);
        System.out.println("update = " + update);
        request.setAttribute("member", member);
        request.getRequestDispatcher("/member/read.jsp").forward(request, response);
    }

    private void delete(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        ServletContext application = request.getServletContext();
        MemberDAO dao = new MemberDAO(application);
        HttpSession session = request.getSession();
        String loginId = (String) session.getAttribute("loginId");
        if (loginId != null) {
            int delete = dao.delete(loginId);
            System.out.println(delete);
            session.invalidate();
            list(request, response);
        }
    }

    @Override
    public void destroy() {
    }
}
