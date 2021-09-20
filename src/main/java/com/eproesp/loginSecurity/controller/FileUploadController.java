package com.eproesp.loginSecurity.controller;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.eproesp.loginSecurity.dao.AlunoDao;
import com.eproesp.loginSecurity.dao.AlunoDaoLeg;
import com.eproesp.loginSecurity.entity.Aluno;
import com.eproesp.loginSecurity.entity.Avaliacoes;
import com.eproesp.loginSecurity.entity.Instituicao;
import com.eproesp.loginSecurity.service.AlunoService;
import com.eproesp.loginSecurity.service.InstituicaoService;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.hssf.converter.ExcelToFoUtils;
import org.apache.poi.hssf.extractor.ExcelExtractor;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
@Controller
public class FileUploadController {
	@Autowired
	private AlunoService service;
	@Autowired
	private InstituicaoService service1;
	/**
	 * @param args
	 * @throws ParseException
	 * @throws IOException
	 */
  public static String uploadDirectory = System.getProperty("user.dir")+"/uploads";
  @RequestMapping("/uploadview")
  public String UploadPage(Model model) {
	  return "uploadview";
  }

 
  @RequestMapping("/upload")
  public String upload(Model model,@RequestParam("files") MultipartFile[] files,@RequestParam("instituicaoId") Long instituicaoId) throws ParseException {
	  Instituicao instituicao = service1.buscarPorId(instituicaoId);
	  Avaliacoes statusSet = new Avaliacoes();
	  StringBuilder fileNames = new StringBuilder();
	  for (MultipartFile file : files) {
		  Path fileNameAndPath = Paths.get(uploadDirectory, file.getOriginalFilename());
		  fileNames.append(file.getOriginalFilename()+" ");
		  try {
			Files.write(fileNameAndPath, file.getBytes());
			DataFormatter dataFormatter = new DataFormatter();
			DateFormat df = new SimpleDateFormat("yyyy-MM-dd");
			List<Aluno> alunos = new ArrayList<>();
			try (InputStream inp = new FileInputStream("uploads/"+fileNames.toString())) {
				Workbook wb = WorkbookFactory.create(inp);

				for (Sheet s : wb) {
					System.out.println(s.getSheetName());
				}

				Sheet sheet = wb.getSheetAt(1);

				for (int r = sheet.getFirstRowNum(); r <= sheet.getLastRowNum(); r++) {
					
					AlunoDaoLeg daoTest = new AlunoDaoLeg();
					Aluno aluno = new Aluno();
					
					Row row = sheet.getRow(r);
					String nome = null, esporte = null, sexo = null, freqSemanal = null, duracaoMediaSecao = null,
							tempoPratica = null, deficiencia = null, dataAv = null, horarioAv= null, temperaturaAv = null;
					double massaCorporal = 0, estatura = 0, envergadura = 0, testeQuadrado = 0, perimetroCint = 0, sentarAlcancar = 0,
							corrida6min = 0, corrida9min = 0, saltoDistancia = 0, arremessoBall = 0;
					int idade = 0, qtdAbdominal = 0,  corrida20metros = 0, gorduraTriciptal = 0, gorduraAxilarMed = 0;
					Date dataN = null, dataAav = null;
					for (int c = row.getFirstCellNum(); c < row.getLastCellNum(); c++) {
						Cell cell = row.getCell(c);

						String output = "";
						if (cell == null) {
							output = "EMPTY";
						} else {
							String cellValue = dataFormatter.formatCellValue(cell);

							Object typedCellValue = ExcelUtils.getTypedValue(cell);

							output = "" + typedCellValue;
							if (row.getRowNum() >= 7 && cell.getColumnIndex() == 1) {
								nome = (String) typedCellValue;
							}
							if (row.getRowNum() >= 7 && cell.getColumnIndex() == 5) {
								esporte = (String) typedCellValue;
							}
							if (row.getRowNum() >= 7 && cell.getColumnIndex() == 3) {
								if ((String) typedCellValue != "") {
									double x = Double.parseDouble((String) typedCellValue);
									idade = (int) x;
								}
							}
							if (row.getRowNum() >= 7 && cell.getColumnIndex() == 2) {
								if ((String) typedCellValue != null) {
									String data = (String) typedCellValue;
									dataN = df.parse(data);
								}
							}
							if (row.getRowNum() >= 7 && cell.getColumnIndex() == 4) {
								sexo = (String) typedCellValue;
							}
							if (row.getRowNum() >= 7 && cell.getColumnIndex() == 6) {
								freqSemanal = (String) typedCellValue;
							}
							if (row.getRowNum() >= 7 && cell.getColumnIndex() == 7) {
								duracaoMediaSecao = (String) typedCellValue;
							}
							if (row.getRowNum() >= 7 && cell.getColumnIndex() == 8) {
								tempoPratica = (String) typedCellValue;
							}
							if (row.getRowNum() >= 7 && cell.getColumnIndex() == 9) {
								deficiencia = (String) typedCellValue;
							}
							if (row.getRowNum() >= 7 && cell.getColumnIndex() == 10) {
								if ((String) typedCellValue != null) {
									String data = (String) typedCellValue;
									dataAav = df.parse(data);
								}
							}
							if (row.getRowNum() >= 7 && cell.getColumnIndex() == 11) {
								horarioAv = (String) typedCellValue;
//								int hora = Integer.parseInt(horarioAv.substring(0, 2));
//								int minuto = Integer.parseInt(horarioAv.substring(3, 5));
//								System.out.println("AQUI:" +horarioAv);
//								dataAav = addHoursToJavaUtilDate(dataAav, hora, minuto);
							}
							if (row.getRowNum() >= 7 && cell.getColumnIndex() == 12) {
								temperaturaAv = (String) typedCellValue;
							}
							if (row.getRowNum() >= 7 && cell.getColumnIndex() == 13) {
								if ((String) typedCellValue != null) {
									double x = Double.parseDouble((String) typedCellValue);
									massaCorporal = x;
								}
							}
							if (row.getRowNum() >= 7 && cell.getColumnIndex() == 14) {
								if ((String) typedCellValue != null) {
									double x = Double.parseDouble((String) typedCellValue);
									estatura = x;
								}
							}
							if (row.getRowNum() >= 7 && cell.getColumnIndex() == 15) {
								if ((String) typedCellValue != null) {
									double x = Double.parseDouble((String) typedCellValue);
									envergadura = x;
								}
							}
							if (row.getRowNum() >= 7 && cell.getColumnIndex() == 16) {
								if ((String) typedCellValue != null) {
									double x = Double.parseDouble((String) typedCellValue);
									perimetroCint = x;
								}
							}
							if (row.getRowNum() >= 7 && cell.getColumnIndex() == 17) {
								if ((String) typedCellValue != null) {
									double x = Double.parseDouble((String) typedCellValue);
									sentarAlcancar = x;
								}
							}
							if (row.getRowNum() >= 7 && cell.getColumnIndex() == 18) {
								if ((String) typedCellValue != null) {
									double x = Double.parseDouble((String) typedCellValue);
									qtdAbdominal = (int) x;
								}
							}
							if (row.getRowNum() >= 7 && cell.getColumnIndex() == 19) {
								if ((String) typedCellValue != null) {
									double x = Double.parseDouble((String) typedCellValue);
									corrida6min = x;
								}
							}
							if (row.getRowNum() >= 7 && cell.getColumnIndex() == 20) {
								if ((String) typedCellValue != null) {
									double x = Double.parseDouble((String) typedCellValue);
									corrida9min = x;
								}
							}
							if (row.getRowNum() >= 7 && cell.getColumnIndex() == 21) {
								if ((String) typedCellValue != null) {
									double x = Double.parseDouble((String) typedCellValue);
									saltoDistancia = x;
								}
							}
							if (row.getRowNum() >= 7 && cell.getColumnIndex() == 22) {
								if ((String) typedCellValue != null) {
									double x = Double.parseDouble((String) typedCellValue);
									arremessoBall = x;
								}
							}
							if (row.getRowNum() >= 7 && cell.getColumnIndex() == 23) {
								if ((String) typedCellValue != null) {
									double x = Double.parseDouble((String) typedCellValue);
									testeQuadrado =  x;
								}
							}
							if (row.getRowNum() >= 7 && cell.getColumnIndex() == 24) {
								if ((String) typedCellValue != null) {
									double x = Double.parseDouble((String) typedCellValue);
									corrida20metros = (int) x;
								}
							}
							if (row.getRowNum() >= 7 && cell.getColumnIndex() == 25) {
								if ((String) typedCellValue != null) {
									double x = Double.parseDouble((String) typedCellValue);
									gorduraTriciptal = (int) x;
								}
							}
							if (row.getRowNum() >= 7 && cell.getColumnIndex() == 26) {
								if ((String) typedCellValue != null) {
									double x = Double.parseDouble((String) typedCellValue);
									gorduraAxilarMed = (int) x;
								}
							}
						}
						System.out.print(String.format("%-20.20s", output) + " | ");

					}
					if (nome != null) {
						aluno.setNome(nome);
						aluno.setEsporte(esporte);
						aluno.setIdade(idade);
						aluno.setDataN(dataN);
						aluno.setSexo(sexo);
						aluno.setFreqSemanal(freqSemanal);
						aluno.setDuracaoMediaSecao(duracaoMediaSecao);
						aluno.setTempoPratica(tempoPratica);
						aluno.setDeficiencia(deficiencia);
						aluno.setDataAv(dataAav);
						aluno.setHoraAv(horarioAv);
						aluno.setTemperaturaAv(temperaturaAv);
						aluno.setMassaCorporal(massaCorporal);
						aluno.setEstatura(estatura);
						aluno.setEnvergadura(envergadura);
						aluno.setPerimetroCint(perimetroCint);
						aluno.setSentarAlcancar(sentarAlcancar);
						aluno.setQtdAbdominal(qtdAbdominal);
						aluno.setCorrida6min(corrida6min);
						aluno.setCorrida9min(corrida9min);
						aluno.setSaltoDistancia(saltoDistancia);
						aluno.setArremessoBall(arremessoBall);
						aluno.setTesteQuadrado(testeQuadrado);
						aluno.setCorrida20metros(corrida20metros);
						aluno.setGorduraTriciptal(gorduraTriciptal);
						aluno.setGorduraAxilarMed(gorduraAxilarMed);
						aluno.setInstituicao(instituicao);
						double imc = aluno.getMassaCorporal()/((aluno.getEstatura()/100)*(aluno.getEstatura()/100));
						aluno.setImc(imc);
						aluno.setPercentualGordura(statusSet.percentualGordura(aluno.getSexo(), aluno.getIdade(), aluno.getGorduraTriciptal(), aluno.getGorduraAxilarMed()));
						aluno.setStatusImc(statusSet.statusImc(imc, aluno.getSexo(), aluno.getIdade()));
						aluno.setStatusCorrida6min(statusSet.statusAptCardio(aluno.getCorrida6min(), aluno.getSexo(), aluno.getIdade()));
						aluno.setStatusFlexibilidade(statusSet.statusFlexibilidade(aluno.getSentarAlcancar(), aluno.getSexo(), aluno.getIdade()));
						aluno.setStatusAbdominal(statusSet.statusResistenciaMuscular(aluno.getQtdAbdominal(), aluno.getSexo(), aluno.getIdade()));
						aluno.setStatusFsuperior(statusSet.buscarResultado(aluno.getIdade(), aluno.getArremessoBall(), 1, aluno.getSexo()));
						aluno.setStatusFinferior(statusSet.buscarResultado(aluno.getIdade(), aluno.getSaltoDistancia(), 2, aluno.getSexo()));
						aluno.setStatusResistencia(statusSet.buscarResultado(aluno.getIdade(), aluno.getCorrida6min(), 3, aluno.getSexo()));
						aluno.setStatusAgilidade(statusSet.buscarResultado2(aluno.getIdade(), aluno.getTesteQuadrado(), 1, aluno.getSexo()));
						aluno.setStatusVelocidade(statusSet.buscarResultado2(aluno.getIdade(), aluno.getCorrida20metros(), 2, aluno.getSexo()));
						aluno.setStatusGordura(statusSet.statusGordura(aluno.getPercentualGordura(), aluno.getSexo()));
						alunos.add(aluno);
						
						service.salvar(aluno);
					}
					System.out.print("\n");
				}
				for (int i = 0; i < alunos.size(); i++) {
					System.out.println(alunos.get(i).getNome() + "-" + alunos.get(i).getEsporte() + "-" +alunos.get(i).getHoraAv());
				}
				


			} catch (FileNotFoundException ex) {
				System.out.println("The file could not be read : " + ex.getMessage());
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (NullPointerException ex) {
				System.out.println("graulin grulers");
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	  }
	  model.addAttribute("msg", "Successfully uploaded files "+fileNames.toString());
	  return "uploadstatusview";
  }
  
  
}
