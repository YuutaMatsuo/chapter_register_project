package servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/register")
public class RegisterServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// doGet()が動いても、doPost()と同じ内容を実行したい場合（習慣的な書き方）
		doPost(request,response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset=utf-8");
		PrintWriter out = response.getWriter();

		// ブラウザから取得した値をServletを用いて出力する
		out.println("<html>");
		out.println("<head>");
		out.println("<title>確認画面</title>");
		out.println("</head");
		out.println("<body>");
		out.println("<h2>入力情報を確認して登録ボタンを押してください</h2>");
		out.println("名前：<strong>" + request.getParameter("name") + "</strong><br>");
		out.println("パスワード：<strong>" + request.getParameter("pass") + "</strong><br>");

		// name属性「age」に紐づいている値（value属性で指定した値）によって分岐する処理
		// 「age」がnullだった場合例外が発生してしまう…
		String age = request.getParameter("age");
		if (age.equals("child")) {
			age = "18歳未満";
		} else {
			age = "18歳以上";
		}
		out.println("年齢：<strong>" + age + "</strong><br>");

		// name属性「lang」に紐づいている複数の値を「一次元配列」として取得
		String[] langs = request.getParameterValues("lang");
		out.println("開発経験：<strong>");
		for (int i = 0; i < langs.length; i++) {
			out.println(langs[i] + " ");
		}
		out.println("</strong>");

		out.println("住所：<strong>" + request.getParameter("address") + "</strong><br>");
		out.println("ご意見・お問い合わせ：<strong><br>" + request.getParameter("msg") + "</strong><br>");
		out.println("（この画面はサーブレットで出力しています）<br>");
		out.println("<input type=\"submit\" value=\"登録\"");
		out.println("</body>");
		out.println("</html>");
	}
}
