package com.eproesp.loginSecurity.entity;

import java.util.List;

public class Avaliacoes {

	// F R B MB EXC
	int[][] MSuperior = { { 145, 159, 160, 182, 183, 239, 240 }, { 164, 179, 180, 201, 202, 249, 250 },
			{ 180, 199, 200, 224, 225, 269, 270 }, { 200, 219, 220, 249, 250, 299, 300 },
			{ 212, 239, 240, 269, 270, 329, 330 }, { 238, 260, 261, 293, 294, 361, 362 },
			{ 264, 296, 297, 329, 330, 422, 423 }, { 300, 339, 340, 389, 390, 499, 500 },
			{ 350, 399, 400, 449, 450, 561, 562 }, { 400, 439, 440, 499, 500, 608, 609 },
			{ 453, 499, 500, 552, 553, 699, 700 }, { 480, 521, 520, 589, 590, 689, 690 } };

	int[][] FSuperior = { { 140, 149, 150, 163, 164, 207, 208 }, { 153, 161, 162, 179, 180, 216, 217 },
			{ 167, 184, 185, 199, 200, 246, 247 }, { 185, 200, 201, 225, 226, 279, 280 },
			{ 200, 219, 220, 244, 245, 301, 302 }, { 220, 246, 247, 276, 275, 329, 330 },
			{ 241, 269, 270, 299, 300, 369, 370 }, { 265, 294, 295, 322, 323, 399, 400 },
			{ 280, 309, 310, 343, 344, 417, 418 }, { 300, 329, 330, 359, 360, 429, 430 },
			{ 320, 339, 340, 369, 370, 449, 450 }, { 310, 339, 340, 374, 375, 440, 441 } };

	int[][] MInferior = { { 105, 114, 115, 127, 128, 151, 152 }, { 111, 121, 122, 133, 134, 159, 160 },
			{ 118, 127, 128, 139, 140, 165, 166 }, { 129, 139, 140, 151, 152, 178, 179 },
			{ 135, 146, 147, 157, 158, 187, 188 }, { 140, 151, 152, 164, 165, 191, 192 },
			{ 149, 159, 160, 173, 174, 203, 204 }, { 159, 169, 170, 184, 185, 216, 217 },
			{ 170, 183, 184, 199, 200, 230, 231 }, { 180, 193, 194, 209, 210, 242, 243 },
			{ 186, 199, 200, 214, 215, 248, 249 }, { 186, 203, 204, 219, 220, 250, 251 } };

	int[][] FInferior = { { 90, 100, 101, 112, 113, 143, 144 }, { 94, 105, 106, 115, 116, 146, 147 },
			{ 105, 112, 113, 126, 127, 152, 153 }, { 116, 126, 127, 139, 140, 165, 166 },
			{ 123, 133, 134, 145, 146, 173, 174 }, { 127, 137, 138, 149, 150, 179, 180 },
			{ 130, 140, 141, 154, 155, 184, 185 }, { 133, 144, 145, 159, 160, 189, 190 },
			{ 134, 146, 147, 160, 161, 198, 199 }, { 135, 147, 148, 162, 163, 198, 199 },
			{ 131, 142, 143, 158, 159, 191, 192 }, { 121, 134, 135, 152, 153, 189, 190 } };

	int[][] MResistencia = { { 690, 740, 741, 780, 781, 878, 879 }, { 735, 785, 786, 824, 825, 923, 924 },
			{ 773, 825, 826, 878, 879, 1009, 1010 }, { 845, 899, 900, 965, 966, 1096, 1097 },
			{ 880, 941, 942, 1009, 1010, 1157, 1158 }, { 915, 977, 978, 1049, 1050, 1189, 1190 },
			{ 965, 1029, 1030, 1109, 1100, 1254, 1255 }, { 983, 1082, 1083, 1158, 1159, 1319, 1320 },
			{ 1068, 1134, 1135, 1209, 1210, 1371, 1372 }, { 1120, 1186, 1187, 1261, 1262, 1434, 1435 },
			{ 1150, 1219, 1220, 1288, 1289, 1504, 1505 }, { 1156, 1219, 1220, 1288, 1289, 1505, 1506 } };
	int[][] FResistencia = { { 612, 640, 641, 680, 681, 831, 832 }, { 652, 682, 683, 729, 730, 851, 852 },
			{ 700, 734, 735, 777, 778, 874, 875 }, { 750, 789, 790, 840, 841, 965, 966 },
			{ 783, 831, 832, 883, 884, 1026, 1027 }, { 822, 867, 868, 919, 920, 1042, 1043 },
			{ 855, 900, 901, 957, 958, 1080, 1081 }, { 887, 934, 935, 996, 997, 1128, 1129 },
			{ 920, 966, 967, 1023, 1024, 1163, 1164 }, { 955, 999, 1000, 1043, 1044, 1204, 1205 },
			{ 970, 1009, 1010, 1054, 1055, 1155, 1156 }, { 982, 1022, 1023, 1062, 1063, 1206, 1207 } };

	public String buscarResultado(int idade, double valor, int tipoTeste, String sexo) {
		int[][] temp = new int[12][7];

		if (tipoTeste == 1 && sexo.equals("M")) {
			temp = MSuperior;
		}
		if (tipoTeste == 1 && sexo.equals("F")) {
			temp = FSuperior;
		}
		if (tipoTeste == 2 && sexo.equals("M")) {
			temp = MInferior;
		}
		if (tipoTeste == 2 && sexo.equals("F")) {
			temp = FInferior;
		}
		if (tipoTeste == 3 && sexo.equals("M")) {
			temp = MResistencia;
		}

		if (tipoTeste == 3 && sexo.equals("F")) {
			temp = FResistencia;
		}

		int linha = idade - 6;
		if (valor < temp[linha][0]) {
			return "FRACO";
		} else if (valor >= temp[linha][0] && valor <= temp[linha][1]) {
			return "RAZOAVEL";
		} else if (valor >= temp[linha][2] && valor <= temp[linha][3]) {
			return "BOM";
		} else if (valor >= temp[linha][4] && valor <= temp[linha][5]) {
			return "MUITO BOM";
		} else if (valor >= temp[linha][6]) {
			return "EXCELENTE";
		}
		return null;
	}

	double[][] MAgilidade = { { 6.40, 6.41, 7.30, 7.31, 7.79, 7.80, 8.19 },
			{ 6.07, 6.08, 7.00, 7.01, 7.43, 7.44, 7.76 }, { 5.97, 5.98, 6.78, 6.79, 7.20, 7.21, 7.59 },
			{ 5.81, 5.82, 6.50, 6.51, 6.89, 6.90, 7.19 }, { 5.58, 5.59, 6.25, 6.26, 6.66, 6.67, 7.00 },
			{ 5.39, 5.40, 6.10, 6.11, 6.50, 6.51, 6.87 }, { 5.17, 5.18, 6.00, 6.01, 6.34, 6.35, 6.70 },
			{ 5.00, 5.01, 5.86, 5.87, 6.16, 6.17, 6.53 }, { 5.00, 5.01, 5.69, 5.70, 6.00, 6.01, 6.37 },
			{ 4.91, 4.92, 5.59, 5.60, 5.99, 6.00, 6.26 }, { 4.90, 4.91, 5.42, 5.43, 5.75, 5.76, 6.10 },
			{ 4.90, 4.91, 5.43, 5.44, 5.75, 5.76, 6.03 } };

	double[][] FAgilidade = { { 6.58, 6.59, 7.66, 7.67, 8.26, 8.27, 8.68 },
			{ 6.56, 6.57, 7.56, 7.57, 8.00, 8.01, 8.41 }, { 6.40, 6.41, 7.22, 7.23, 7.59, 7.60, 7.98 },
			{ 6.03, 6.04, 6.89, 6.90, 7.25, 7.26, 7.63 }, { 5.88, 5.89, 6.60, 6.61, 7.00, 7.01, 7.35 },
			{ 5.72, 5.73, 6.49, 6.50, 6.90, 6.91, 7.24 }, { 5.63, 5.64, 6.36, 6.37, 6.80, 6.81, 7.17 },
			{ 5.57, 5.58, 6.28, 6.29, 6.70, 6.71, 7.10 }, { 5.49, 5.50, 6.22, 6.23, 6.68, 6.69, 7.03 },
			{ 5.33, 5.34, 6.19, 6.20, 6.66, 6.67, 7.00 }, { 5.41, 5.42, 6.15, 6.16, 6.55, 6.56, 6.94 },
			{ 5.54, 5.55, 6.22, 6.23, 6.58, 6.59, 7.00 } };

	double[][] MVelocidade = { { 3.72, 3.73, 4.20, 4.21, 4.53, 4.54, 4.80 },
			{ 3.65, 3.66, 4.12, 4.13, 4.42, 4.43, 4.62 }, { 3.50, 3.51, 4.00, 4.01, 4.21, 4.22, 4.47 },
			{ 3.15, 3.16, 3.88, 3.89, 4.09, 4.10, 4.31 }, { 3.07, 3.08, 3.74, 3.75, 3.98, 3.99, 4.15 },
			{ 3.00, 3.01, 3.62, 3.63, 3.86, 3.87, 4.03 }, { 3.00, 3.01, 3.50, 3.51, 3.74, 3.75, 3.96 },
			{ 3.00, 3.01, 3.37, 3.38, 3.60, 3.61, 3.81 }, { 2.90, 2.91, 3.23, 3.24, 3.46, 3.47, 3.67 },
			{ 2.87, 2.88, 3.16, 3.17, 3.38, 3.39, 3.60 }, { 2.78, 2.79, 3.12, 3.13, 3.31, 3.32, 3.50 },
			{ 2.72, 2.73, 3.12, 3.13, 3.30, 3.31, 3.53 } };

	double[][] FVelocidade = { { 4.01, 4.02, 4.54, 4.55, 4.83, 4.84, 5.11 },
			{ 3.90, 3.91, 4.47, 4.48, 4.77, 4.78, 5.07 }, { 3.87, 3.88, 4.27, 4.28, 4.53, 4.54, 4.75 },
			{ 3.55, 3.56, 4.00, 4.01, 4.28, 4.29, 4.54 }, { 3.43, 3.44, 3.97, 3.98, 4.16, 4.17, 4.41 },
			{ 3.29, 3.30, 3.87, 3.88, 4.09, 4.10, 4.31 }, { 3.07, 3.08, 3.78, 3.79, 4.00, 4.01, 4.25 },
			{ 3.00, 3.01, 3.71, 3.72, 3.98, 3.99, 4.19 }, { 3.00, 3.01, 3.70, 3.71, 3.97, 3.98, 4.21 },
			{ 3.05, 3.06, 3.72, 3.73, 4.00, 4.01, 4.25 }, { 3.24, 3.25, 3.70, 3.71, 4.00, 4.01, 4.23 },
			{ 3.16, 3.17, 3.79, 3.80, 4.07, 4.08, 4.32 } };

	public String buscarResultado2(int idade, double valor, int tipoTeste, String sexo) {
		double[][] temp = new double[12][7];

		if (tipoTeste == 1 && sexo.equals("M")) {
			temp = MAgilidade;
		}
		if (tipoTeste == 1 && sexo.equals("F")) {
			temp = FAgilidade;
		}
		if (tipoTeste == 2 && sexo.equals("M")) {
			temp = MVelocidade;
		}
		if (tipoTeste == 2 && sexo.equals("F")) {
			temp = FVelocidade;
		}

		int linha = idade - 6;

		if (valor <= temp[linha][0]) {
			return "EXCELENTE";
		} else if (valor >= temp[linha][1] && valor <= temp[linha][2]) {
			return "MUITO BOM";
		} else if (valor >= temp[linha][3] && valor <= temp[linha][4]) {
			return "BOM";
		} else if (valor >= temp[linha][5] && valor <= temp[linha][6]) {
			return "RAZOAVEL";
		} else if (valor > temp[linha][6]) {
			return "FRACO";
		}
		return null;
	}

	public String statusAptCardio(double aptCardio, String sexo, int idade) {
		if (sexo.equals("M")) {
			if ((idade == 6 && aptCardio < 675.0) || (idade == 7 && aptCardio < 730) || (idade == 8 && aptCardio < 768)
					|| (idade == 9 && aptCardio < 820) || (idade == 10 && aptCardio < 856)
					|| (idade == 11 && aptCardio < 930) || (idade == 12 && aptCardio < 966)
					|| (idade == 13 && aptCardio < 995) || (idade == 14 && aptCardio < 1060)
					|| (idade == 15 && aptCardio < 1130) || (idade == 16 && aptCardio < 1190)
					|| (idade == 17 && aptCardio < 1190)) {
				return "ZONA DE RISCO";
			} else {
				return "ZONA SAUDAVEL";
			}
		} else if (sexo.equals("F")) {
			if ((idade == 6 && aptCardio < 630) || (idade == 7 && aptCardio < 683) || (idade == 8 && aptCardio < 715)
					|| (idade == 9 && aptCardio < 745) || (idade == 10 && aptCardio < 790)
					|| (idade == 11 && aptCardio < 840) || (idade == 12 && aptCardio < 900)
					|| (idade == 13 && aptCardio < 940) || (idade == 14 && aptCardio < 985)
					|| (idade == 15 && aptCardio < 1005) || (idade == 16 && aptCardio < 1070)
					|| (idade == 17 && aptCardio < 1110)) {
				return "ZONA DE RISCO";
			} else {
				return "ZONA SAUDAVEL";
			}
		}
		return "";
	}

	public String statusImc(double imc, String sexo, int idade) {
		if (sexo.equals("M")) {
			if ((idade <= 6 && imc > 17.7) || (idade == 7 && imc > 17.8) || (idade == 8 && imc > 19.2)
					|| (idade == 9 && imc > 19.3) || (idade == 10 && imc > 20.7) || (idade == 11 && imc > 22.1)
					|| (idade == 12 && imc > 22.2) || (idade == 13 && imc > 22.0) || (idade == 14 && imc > 22.2)
					|| (idade == 15 && imc > 23.0) || (idade == 16 && imc > 24.0) || (idade == 17 && imc > 25.4)) {
				return "ZONA DE RISCO";

			} else {
				return "ZONA SAUDAVEL";
			}

		} else if (sexo.equals("F")) {
			if ((idade <= 6 && imc > 17.0) || (idade == 7 && imc > 17.1) || (idade == 8 && imc > 18.2)
					|| (idade == 9 && imc > 19.1) || (idade == 10 && imc > 20.9) || (idade == 11 && imc > 22.3)
					|| (idade == 12 && imc > 22.6) || (idade == 13 && imc > 22.0) || (idade == 14 && imc > 22.0)
					|| (idade == 15 && imc > 22.4) || (idade == 16 && imc > 24.0) || (idade >= 17 && imc > 24.0)) {
				return "ZONA DE RISCO";

			} else {
				return "ZONA SAUDAVEL";
			}
		}
		return "";
	}

	public String statusFlexibilidade(double flexibilidade, String sexo, int idade) {
		if (sexo.equals("M")) {
			if ((idade == 6 && flexibilidade < 29.3) || (idade == 7 && flexibilidade < 29.3)
					|| (idade == 8 && flexibilidade < 29.3) || (idade == 9 && flexibilidade < 29.3)
					|| (idade == 10 && flexibilidade < 29.4) || (idade == 11 && flexibilidade < 27.8)
					|| (idade == 12 && flexibilidade < 24.7) || (idade == 13 && flexibilidade < 23.1)
					|| (idade == 14 && flexibilidade < 22.9) || (idade == 15 && flexibilidade < 24.3)
					|| (idade == 16 && flexibilidade < 25.7) || (idade == 17 && flexibilidade < 25.7)) {
				return "ZONA DE RISCO";
			} else {
				return "ZONA SAUDAVEL";
			}
		} else if (sexo.equals("F")) {
			if ((idade == 6 && flexibilidade < 21.4) || (idade == 7 && flexibilidade < 21.4)
					|| (idade == 8 && flexibilidade < 21.4) || (idade == 9 && flexibilidade < 21.4)
					|| (idade == 10 && flexibilidade < 23.5) || (idade == 11 && flexibilidade < 23.5)
					|| (idade == 12 && flexibilidade < 23.5) || (idade == 13 && flexibilidade < 23.5)
					|| (idade == 14 && flexibilidade < 24.3) || (idade == 15 && flexibilidade < 24.3)
					|| (idade == 16 && flexibilidade < 24.3) || (idade == 17 && flexibilidade < 24.3)) {
				return "ZONA DE RISCO";
			} else {
				return "ZONA SAUDAVEL";
			}
		}
		return "";
	}

	public double percentualGordura(String sexo, int idade, int tr, int ax) {
		double var = 0;
		if (sexo.equals("M")) {
			var = 12.66 - 0.85 * idade + 1.10 * tr + 0.53 * ax;
		}
		if (sexo.equals("F")) {
			var = 17.19 - 0.74 * idade + 1.02 * tr + 0.32 * ax;
		}

		return var;

	}

	public String statusResistenciaMuscular(double resistencia, String sexo, int idade) {
		if (sexo.equals("M")) {
			if ((idade == 6 && resistencia < 20) || (idade == 7 && resistencia < 20) || (idade == 8 && resistencia < 20)
					|| (idade == 9 && resistencia < 22) || (idade == 10 && resistencia < 22)
					|| (idade == 11 && resistencia < 25) || (idade == 12 && resistencia < 30)
					|| (idade == 13 && resistencia < 35) || (idade == 14 && resistencia < 35)
					|| (idade == 15 && resistencia < 35) || (idade == 16 && resistencia < 40)
					|| (idade == 17 && resistencia < 40)) {
				return "ZONA DE RISCO";
			} else {
				return "ZONA SAUDAVEL";
			}
		} else if (sexo.equals("F")) {
			if ((idade == 6 && resistencia < 20) || (idade == 7 && resistencia < 20) || (idade == 8 && resistencia < 20)
					|| (idade == 9 && resistencia < 20) || (idade == 10 && resistencia < 20)
					|| (idade == 11 && resistencia < 20) || (idade == 12 && resistencia < 20)
					|| (idade == 13 && resistencia < 23) || (idade == 14 && resistencia < 23)
					|| (idade == 15 && resistencia < 23) || (idade == 16 && resistencia < 23)
					|| (idade == 17 && resistencia < 23)) {
				return "ZONA DE RISCO";
			} else {
				return "ZONA SAUDAVEL";
			}
		}
		return "";
	}

	public double calcularMediana(List<Double> numeros) {

		double resultado = 0.0f;

		if (numeros.size() % 2 != 0) {
			int posicaoNumero = ((numeros.size() + 1) / 2) - 1;
			resultado = numeros.get(posicaoNumero);
		} else {
			int posicaoNumero = Math.round((numeros.size() + 1) / 2) - 1;
			resultado = (numeros.get(posicaoNumero) + numeros.get(posicaoNumero + 1)) / 2;
		}

		System.out.println("A Mediana dos números citados é " + resultado);
		return resultado;
	}

	public double calcularDesvioPadrao(List<Double> numeros, double media) {
		double somaNumeros = 0.0f;
		for (int i = 0; i < numeros.size(); i++) {
			somaNumeros += Math.pow(numeros.get(i), 2);
		}
		double resultado = (somaNumeros / numeros.size()) - Math.pow(media, 2);
		double desvio = Math.sqrt(resultado);
		return desvio;
	}
	public String statusGordura(double gordura, String sexo) {
		if(sexo.equals("F")) {
			if(gordura <= 11) return "MUITO BAIXO";
			if(gordura >=12 && gordura <=15) return "BAIXO";
			if(gordura >=16 && gordura <=25) return "NORMAL";
			if(gordura >=26 && gordura <=30) return "MODERADAMENTE ALTO";
			if(gordura >=31 && gordura <=35) return "ALTO";
			if(gordura >35) return "MUITO ALTO";
		}
		if(sexo.equals("M")) {
			if(gordura <= 6) return "MUITO BAIXO";
			if(gordura >=7 && gordura <=12) return "BAIXO";
			if(gordura >=13 && gordura <=18) return "NORMAL";
			if(gordura >=19 && gordura <=25) return "MODERADAMENTE ALTO";
			if(gordura >=26 && gordura <=32) return "ALTO";
			if(gordura >32) return "MUITO ALTO";
		}
		
		return "";
		
	}

}