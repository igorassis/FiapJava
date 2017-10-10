

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class CalculadoraServlet
 */
@WebServlet("/CalculadoraServlet")
public class CalculadoraServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * Default constructor. 
     */
    public CalculadoraServlet() {
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String n1 = request.getParameter("valor1");
		String n2 = request.getParameter("valor2");
		String operacao  = request.getParameter("op");
		double res = 0;
		
		try{
			double numero1 = Double.parseDouble(n1);
			double numero2 = Double.parseDouble(n2);
			
			switch (operacao) {
				case "Somar":
					res = numero1 + numero2;
					break;
				case "Subtrair":
					res = numero1 - numero2;
					break;
				case "Dividir":
					res = numero1 / numero2;
					break;
				case "Multiplicar":
					res = numero1 * numero2;
					break;
				default:
					res = numero1 + numero2;
				break;
			}
		}catch (NumberFormatException e) {
			PrintWriter out = response.getWriter();
			out.println("<html><body>Resultado = "+res+"</body></html>");
		}
		
	}

}
