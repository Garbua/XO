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
//Проверка победителя игрока:
		winner(pl, "label.winPlayer");
//Ход компьютера:
		ai(request);
//Проверка победителя компьютера:
		winner(pc, "label.winAI");

		request.setAttribute("win", winner);
		winner = "";
		list.clear();


		return "pages/nick";
	}

	public String winner(String p, String r) {

		// проверка горизонтали
		horizontalCheck(p, r);

		//проверка вертикали
		verticalCheck(p, r);

		//проверка диагонали 0-4-8
		diagonalCheck1(p, r);

		//проверка диагонали 2-4-6
		diagonalCheck2(p, r);

		//проверка ничьей
		drawCheck(p, r);

		return winner;

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

	public String horizontalCheck(String p, String r){
		for (int i =0; i < pole * pole; i+=pole) {
			if (winner.equalsIgnoreCase("")) {
				winner = r;
				for (int j = 0; j < pole; j++) {
					if (!map.get(i + j).equalsIgnoreCase(p)) {
						winner = "";
						break;
					}
				}
			}else return winner;
		}
		return winner;
	}

	public String verticalCheck(String p, String r){
		for (int i =0; i < pole * pole; i+=pole) {
			if (winner.equalsIgnoreCase("")){
				winner = r;
				for (int j = 0; j < pole; j++) {
					if (!map.get((i / pole) + (j * pole)).equalsIgnoreCase(p)) {
						winner = "";
						break;
					}
				}
			}else return winner;
		}
		return winner;
	}

	public String diagonalCheck1(String p, String r){
		if (winner.equalsIgnoreCase("")) {
			winner = r;
			for (int i = 0; i < pole * pole; i += pole + 1) {
				if (!map.get(i).equalsIgnoreCase(p)) {
					winner = "";
				}
			}
		}else return winner;
		return winner;
	}

	public String diagonalCheck2(String p, String r){
		if (winner.equalsIgnoreCase("")) {
			winner = r;
			for (int i = pole - 1; i < (pole * pole) - 1; i += pole - 1) {
				if (!map.get(i).equalsIgnoreCase(p)) {
					winner = "";
				}
			}
		}else return winner;
		return winner;
	}

	public String drawCheck(String p, String r){
		String n = "label.winNO";
		if (!map.containsValue("")&& winner.equalsIgnoreCase("")) {
			return winner = n;
		}
		return winner;
	}
}
