package controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.*;

@Controller
@RequestMapping("/controller")
public class ExampleController {
	private Map<Integer, String> map = new HashMap<>();
	private String winner = "";
	private ArrayList<Integer> list = new ArrayList<>();
	private String pl= "x";
	private String pc = "o";
	private int pole = 3;

	@RequestMapping(value = "/player")
	public String Player(HttpServletRequest request) {
//Записываем в мапу состояние игрового поля (ход игрока):
		pole(request);
//Проверка победителя:
		winner(pl);
		win();
//Ход компьютера:
		ai(request);
//Проверка победителя:
		winner(pc);
		win();

		request.setAttribute("win", winner);
		list.clear();


		return "pages/nick";
	}

	public String winner(String p) {
		winner = p;
		String n = "Ничья!";
		// проверка горизонтали
		for (int i =0; i < pole * pole; i+=pole) {
			for (int j = 0; j < pole; j++) {
				if (!map.get(i + j).equalsIgnoreCase(p)) {
					winner = "";
				}
			}
		}

//		for (int i =0; i < pole * pole; i+=pole){
//				for(int j = 0; j < pole; j++)
//					if(!map.get(i+j).equalsIgnoreCase(p)){
//						 winner = "";
//					}
//			}
//		//проверка вертикали
		for (int i =0; i < pole * pole; i+=pole) {
			for (int j = 0; j < pole; j++) {
					if (!map.get((i/pole) + (j * pole) ).equalsIgnoreCase(p)){
						winner = "";
					}
			}
		}

//		for (int k = 0; k < pole; k++){
//			for (int i =0; i < pole * pole; i+=pole)
//			if (!map.get(k + i).equalsIgnoreCase(p)){
//			 winner = "";
//			}
//		}
		//проверка диагонали 0-4-8
		for (int i =0; i < pole * pole; i+=pole+1){
			if (!map.get(i).equalsIgnoreCase(p)){
				winner = "";
			}
		}
		//проверка диагонали 2-4-6
		for (int i = pole - 1; i< (pole*pole)-1; i+= pole -1){
			if (!map.get(i).equalsIgnoreCase(p)){
				winner = "";
			}
		}
		//проверка ничьей
		if (!map.containsValue("")) {
				return winner = n;
			}
			return winner = "";







// пределать проверку
//		if ((map.get(0).equalsIgnoreCase("x") && map.get(1).equalsIgnoreCase("x") && map.get(2).equalsIgnoreCase("x")) ||
//				(map.get(3).equalsIgnoreCase("x") && map.get(4).equalsIgnoreCase("x") && map.get(5).equalsIgnoreCase("x")) ||
//				(map.get(6).equalsIgnoreCase("x") && map.get(7).equalsIgnoreCase("x") && map.get(8).equalsIgnoreCase("x")) ||
//				(map.get(0).equalsIgnoreCase("x") && map.get(3).equalsIgnoreCase("x") && map.get(6).equalsIgnoreCase("x")) ||
//				(map.get(1).equalsIgnoreCase("x") && map.get(4).equalsIgnoreCase("x") && map.get(7).equalsIgnoreCase("x")) ||
//				(map.get(2).equalsIgnoreCase("x") && map.get(5).equalsIgnoreCase("x") && map.get(8).equalsIgnoreCase("x")) ||
//				(map.get(0).equalsIgnoreCase("x") && map.get(4).equalsIgnoreCase("x") && map.get(8).equalsIgnoreCase("x")) ||
//				(map.get(2).equalsIgnoreCase("x") && map.get(4).equalsIgnoreCase("x") && map.get(6).equalsIgnoreCase("x"))) {
//			return winner = user;
//
//		} else if ((map.get(0).equalsIgnoreCase("o") && map.get(1).equalsIgnoreCase("o") && map.get(2).equalsIgnoreCase("o")) ||
//				(map.get(3).equalsIgnoreCase("o") && map.get(4).equalsIgnoreCase("o") && map.get(5).equalsIgnoreCase("o")) ||
//				(map.get(6).equalsIgnoreCase("o") && map.get(7).equalsIgnoreCase("o") && map.get(8).equalsIgnoreCase("o")) ||
//				(map.get(0).equalsIgnoreCase("o") && map.get(3).equalsIgnoreCase("o") && map.get(6).equalsIgnoreCase("o")) ||
//				(map.get(1).equalsIgnoreCase("o") && map.get(4).equalsIgnoreCase("o") && map.get(7).equalsIgnoreCase("o")) ||
//				(map.get(2).equalsIgnoreCase("o") && map.get(5).equalsIgnoreCase("o") && map.get(8).equalsIgnoreCase("o")) ||
//				(map.get(0).equalsIgnoreCase("o") && map.get(4).equalsIgnoreCase("o") && map.get(8).equalsIgnoreCase("o")) ||
//				(map.get(2).equalsIgnoreCase("o") && map.get(4).equalsIgnoreCase("o") && map.get(6).equalsIgnoreCase("o"))) {
//			return winner = ai;
//
//		} else if (!map.containsValue("")) {
//			return winner = n;
//		} else {
//			return winner = "";
//		}
	}


	public void ai(HttpServletRequest request) {
		Random random = new Random();
		if (winner.equals("") && (list.size() != 0)) {
			int ai = random.nextInt(list.size());
			map.put(list.get(ai), "o");
			request.setAttribute("p" + list.get(ai), map.get(list.get(ai)));
			return;

		}
	}

	public void pole(HttpServletRequest request) {
		for (int i = 0; i <= (pole * pole)-1 ; i++) {
			String param = String.valueOf(i);
			map.put(i, request.getParameter(param));
			request.setAttribute("p" + i, map.get(i));
			if (map.get(i).equals("")) {
				list.add(i);
			}

		}


	}

	public void win(){
		String user = "Победил игрок!";
		String ai = "Победил компьютер!";
		if (winner.equalsIgnoreCase(pl)){
			winner = user;
		}else if (winner.equalsIgnoreCase(pc)){
			winner = ai;
		}else winner = "";

	}
}
