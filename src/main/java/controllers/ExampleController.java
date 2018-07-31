package controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;

@Controller
@RequestMapping("/controller")
public class ExampleController {
	private Map <Integer, String> map = new HashMap<>();
	private String winner = "";

	@RequestMapping(value = "/player")
	public String Player(HttpServletRequest request) {
//Записываем в мапу состояние игрового поля (ход игрока):
		map.put(0,request.getParameter("0"));
		map.put(1,request.getParameter("1"));
		map.put(2,request.getParameter("2"));
		map.put(3,request.getParameter("3"));
		map.put(4,request.getParameter("4"));
		map.put(5,request.getParameter("5"));
		map.put(6,request.getParameter("6"));
		map.put(7,request.getParameter("7"));
		map.put(8,request.getParameter("8"));
//Проверка победителя:
		winner();
//Ход компьютера:
		ai();
//Проверка победителя:
		winner();
//Передача данных на игровое поле:
		request.setAttribute("pp", map.get(0));
		request.setAttribute("pv", map.get(1));
		request.setAttribute("pt", map.get(2));
		request.setAttribute("vp", map.get(3));
		request.setAttribute("vv", map.get(4));
		request.setAttribute("vt", map.get(5));
		request.setAttribute("tp", map.get(6));
		request.setAttribute("tv", map.get(7));
		request.setAttribute("tt", map.get(8));
		request.setAttribute("win", winner);


		return "pages/nick";
	}

	public String winner() {
		String user = "Победил игрок!";
		String ai = "Победил компьютер!";
		String n = "Ничья!";

		if ((map.get(0).equalsIgnoreCase("x") && map.get(1).equalsIgnoreCase("x") && map.get(2).equalsIgnoreCase("x")) ||
				(map.get(3).equalsIgnoreCase("x") && map.get(4).equalsIgnoreCase("x") && map.get(5).equalsIgnoreCase("x")) ||
				(map.get(6).equalsIgnoreCase("x") && map.get(7).equalsIgnoreCase("x") && map.get(8).equalsIgnoreCase("x")) ||
				(map.get(0).equalsIgnoreCase("x") && map.get(3).equalsIgnoreCase("x") && map.get(6).equalsIgnoreCase("x")) ||
				(map.get(1).equalsIgnoreCase("x") && map.get(4).equalsIgnoreCase("x") && map.get(7).equalsIgnoreCase("x")) ||
				(map.get(2).equalsIgnoreCase("x") && map.get(5).equalsIgnoreCase("x") && map.get(8).equalsIgnoreCase("x")) ||
				(map.get(0).equalsIgnoreCase("x") && map.get(4).equalsIgnoreCase("x") && map.get(8).equalsIgnoreCase("x")) ||
				(map.get(2).equalsIgnoreCase("x") && map.get(4).equalsIgnoreCase("x") && map.get(6).equalsIgnoreCase("x"))) {

			return winner = user;

		} else if ((map.get(0).equalsIgnoreCase("o") && map.get(1).equalsIgnoreCase("o") && map.get(2).equalsIgnoreCase("o")) ||
				(map.get(3).equalsIgnoreCase("o") && map.get(4).equalsIgnoreCase("o") && map.get(5).equalsIgnoreCase("o")) ||
				(map.get(6).equalsIgnoreCase("o") && map.get(7).equalsIgnoreCase("o") && map.get(8).equalsIgnoreCase("o")) ||
				(map.get(0).equalsIgnoreCase("o") && map.get(3).equalsIgnoreCase("o") && map.get(6).equalsIgnoreCase("o")) ||
				(map.get(1).equalsIgnoreCase("o") && map.get(4).equalsIgnoreCase("o") && map.get(7).equalsIgnoreCase("o")) ||
				(map.get(2).equalsIgnoreCase("o") && map.get(5).equalsIgnoreCase("o") && map.get(8).equalsIgnoreCase("o")) ||
				(map.get(0).equalsIgnoreCase("o") && map.get(4).equalsIgnoreCase("o") && map.get(8).equalsIgnoreCase("o")) ||
				(map.get(2).equalsIgnoreCase("o") && map.get(4).equalsIgnoreCase("o") && map.get(6).equalsIgnoreCase("o"))) {

			return winner = ai;

		} else if (!map.containsValue("")){

					return winner = n;
				}else {
			return winner = "";
			}

		}



public void ai(){
		Random random = new Random();


		for (int i = 0; i < 1 ; i--){
			int j = random.nextInt(8);
			if (map.get(j).equals("")){
				map.put(j,"o");
				return;
			}
		}

}
}
