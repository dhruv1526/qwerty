package com.cg.ui;

import java.util.ArrayList;
import java.util.Scanner;

import com.cg.bean.CourseMaster;
import com.cg.bean.EmployeeMaster;
import com.cg.bean.FacultySkill;
import com.cg.bean.FeedbackMaster;
import com.cg.bean.ParticipantEnrollment;
import com.cg.bean.TrainingProgram;
import com.cg.service.IService;
import com.cg.service.IServiceAdmin;
import com.cg.service.IServiceCoord;
import com.cg.service.IServiceParticipant;
import com.cg.service.Service;
import com.cg.service.ServiceAdmin;
import com.cg.service.ServiceCoord;
import com.cg.service.ServiceParticipant;

public class Fmsmain {

	public static void main(String[] args) {
		FeedbackMaster fm = new FeedbackMaster();
		CourseMaster course;
		ParticipantEnrollment enroll = new ParticipantEnrollment();
		Scanner kb = new Scanner(System.in);
		IService service = new Service();
		IServiceAdmin admin = new ServiceAdmin();
		IServiceCoord coord = new ServiceCoord();
		IServiceParticipant participant = new ServiceParticipant();
		String role = "";
		String num = "";
		String skill = "";
		String cname = "";
		int result, fId = 0, tId, id, cId = 0, pId, days = 0;
		int choice = 0;
		int interchoice = 0;
		int cmaint = 0;
		char again = 'y';
		int eid = 0;
		Boolean check = false;
		FacultySkill facultySkill;
		TrainingProgram trainingProgram = new TrainingProgram();
		ArrayList<FacultySkill> fList = new ArrayList<FacultySkill>();
		ArrayList<EmployeeMaster> eList = new ArrayList<EmployeeMaster>();
		ArrayList<CourseMaster> cList = new ArrayList<CourseMaster>();
		
		do {
			do {System.out.println("\n");
				System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~DATA GLOBAL SOLUTION~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~ ");
                System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
                System.out.println("                              WELCOME TO FEEDBACK MANAGEMENT SYSTEM ");
				
				do {System.out.print("Employee ID: ");
					num = kb.next();
					if (service.checkInt(num) == false) {
						System.out
								.println("your Employee ID is a unique number,please input that number\n\n");
				
					} else {
						eid = Integer.parseInt(num);
					}
				} while (service.checkInt(num) == false);
				kb.nextLine();
				System.out.print("passsword: ");
				String pass = kb.nextLine();
				System.out.println("\n ");
			
				Boolean b = service.isValid(eid, pass);
				if (b == true) {
					role = service.validate(eid, pass);
				
					System.out.println("\n~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
					if (role.equals("admin") || role.equals("coordinator") || role.equals("participant"))
						break;
					else
						System.out.println(role);
				} else {
					System.out.println("please enter correct id and password!!");
				}

			} while (true);
			switch (role) {
			case "admin": {
				do {
					System.out.println("1.	Faculty skill Maintenance");
					System.out.println("2.	Course Maintenance");
					System.out.println("3.	View Feedback Report");
					System.out.println("4.  exit");
					System.out.println("Enter your choice:");
					do {
						num = kb.next();
						if (service.checkInt(num) == false) {
							System.out.println("please input only number");
						} else {
							choice = Integer.parseInt(num);
						}
					} while (service.checkInt(num) == false);
					

					switch (choice) {
					case 1: {

						do {
							System.out.println("1. update a faculty skill.");
							System.out
									.println("2. view faculty list along with Skills. ");
							System.out.println("3. view employees.");
							System.out.println("4. exit");
							System.out.println("enter your choice.");
							do {
								num = kb.next();
								if (service.checkInt(num) == false) {
									System.out.println("please input only number:");
								} else {
									interchoice = Integer.parseInt(num);
								}
							} while (service.checkInt(num) == false);
							switch (interchoice) {
							case 1: {
								do {
									System.out.print("enter a faculty Id:");
									do {
										num = kb.next();
										if (service.checkInt(num) == false) {
											System.out
													.println("please input only number");
										} else {
											fId = Integer.parseInt(num);
										}
									} while (service.checkInt(num) == false);
									if (service.validateFID(fId) == false) {
										System.out
												.println("faculty ID not exist.");
										do{
										System.out.println("want to try again(y/n)?");
										
										again = kb.next().trim().charAt(0);
										
											if(again=='y'||again=='Y'||again=='n'||again=='N')
												break;
											else
											{System.out.println("please give proper response..");}
										}while(true);
									} else {

										System.out.println("enter new skill:");
										do {
											num = kb.next();
											kb.nextLine();
											if (service.checkInt(num) == true) {
												System.out
														.println("please input valid skill");
											} else {
												skill = num;
											}
										} while (service.checkInt(num) == true);
										
										
										
										//skill = kb.next();
										
										facultySkill = new FacultySkill(fId,
												skill);
										result = admin
												.addFacultySkill(facultySkill);
										if (result == 0) {
											System.out
													.println("skill not updated.");
											System.out.println("try again? ");
											again = kb.next().trim().charAt(0);
										} else {
											System.out
													.println("skills updated..");
											do{
												System.out
												.println("do you want more updation?(y/n):");
												
												again = kb.next().trim().charAt(0);
												
													if(again=='y'||again=='Y'||again=='n'||again=='N')
														break;
													else
													{System.out.println("please give proper response..");}
												}while(true);
											
											
										}
									}
								} while (again == 'y' || again == 'Y');
								break;
							}
							case 2: {
								fList.clear();
								System.out.println("     ____________________________");
								System.out.println("       Faculty ID       Skill");
								System.out.println("     -----------------------------");
								fList = service.showSkill();
								for (FacultySkill obj : fList) {
									System.out.println(obj);

								}
								break;

							}
							case 3: {
								eList = service.showEmployees();
								for (EmployeeMaster employee : eList) {
									System.out.println(employee);
								}
								break;
							}
							case 4: {
//								for(int i=0;i<40;i++)
//								{System.out.println("\n");}
								again='n';
								break;
							}
							default: {
								System.out
										.println("please enter correct choice");
							}

							}// switch end
								// System.out.println("do you want to continue?");
							// again = kb.next().trim().charAt(0);
						} while ((interchoice != 4)||again=='y'||again=='Y'
								);
						break;

					}

					case 2: {
						do{
						System.out.println("1.  View COURSES.");
						System.out.println("2.  Update Course Details.");
						System.out.println("3.  Exit");
						do {
							num = kb.next();
							if (service.checkInt(num) == false) {
								System.out
										.println("please input only number:");
							} else {
							 cmaint = Integer.parseInt(num);
							}
						} while (service.checkInt(num) == false);
                         	if(cmaint==1)
                         	{
					   cList.clear();
							cList = admin.courseMaintenance();
							System.out.println("______________________________________________________");
							System.out.println("      Course_ID      No_of_Days       Course_Name");
							System.out.println("------------------------------------------------------");
							for (CourseMaster courses : cList) {
								System.out.println(courses);
							}}
							//System.out.println("want to update?(y/n)");
							//again = kb.next().trim().charAt(0);
                         	else if (cmaint==2) {
                         		do{
								System.out.println("enter a course code:");
								do {
									num = kb.next();
									if (service.checkInt(num) == false) {
										System.out
												.println("please input valid course code:");
									} else {
										cId = Integer.parseInt(num);
									}
								} while (service.checkInt(num) == false);
								check = service.validateCID(cId);
								if (check == false) {
									System.out.println("course ID not Exist!!!");
								} else {
									System.out
											.print("enter new name for course: ");
									cname = kb.next();
									System.out.print("\nenter no. of days: ");
									do {
										num = kb.next();
										if (service.checkInt(num) == false) {
											System.out
													.print("\nplease input only number:");
										} else {
											days = Integer.parseInt(num);
										}
									} while (service.checkInt(num) == false);
									course = new CourseMaster(cId, cname, days);
									result = admin.updateCourse(course);
									if (result == 0) {
										System.out.println("updation failed!!!");
									} else
								System.out.println("course updated successfully!!");
									do{
										System.out
										.print("do you want more updation?(y/n):");
										
										again = kb.next().trim().charAt(0);
										
											if(again=='y'||again=='Y'||again=='n'||again=='N')
												break;
											else
											{System.out.println("please give proper response..");}
										}while(true);
//									System.out.println("continue updation?(y/n)");
//									again = kb.next().trim().charAt(0);
								}

							}while (again != 'n' || again == 'N');
						}
                         	else if(cmaint==3)
                         	{
                         		break;
                         	}
                         	else
                         	{
                         		System.out.println("please input corrrect choice.");
                         	}
						}while(cmaint!=3);
						break;

					}
					case 3: {
					
					}
					case 4: {
//						for(int i=0;i<40;i++)
//						{System.out.println("\n");}
						break;
					}
					}
				} while (choice!=4);
				break;
			
			}

			case "coordinator": {

				Boolean b = false;
				Boolean insert;

				do {
					System.out.println("1.	Training program Maintenance");
					System.out.println("2.	Participant Enrollment");
					System.out.println("3.	View Feedback Report");
					System.out.println("4.  exit");
					System.out.println("enter your choice");
					choice = kb.nextInt();
					ArrayList<TrainingProgram> al = new ArrayList<TrainingProgram>();
					int maintain_choice;
					switch (choice) {
					case 1: {do{
						System.out.println("1. Display current programs.");
						System.out.println("2. modify a program");
						System.out.println("3. Add a new program");
						System.out.println("4. Remove a program");
						System.out.println("5. exit");
						maintain_choice = kb.nextInt();
						switch (maintain_choice) {
						case 1:{
							al = coord.trainingMaintenance(); // getting training
							// Program table
							// from
							// database
               System.out.println("Training code "+"     "+"Course code "+"       "+ "Faculty Code"+""  + "     	"+"  startdate "+ "       "+ "endDate");
               System.out.println("--------------------------------------------------------------------------------------------------------------------------------------------------");
                            for (TrainingProgram obj : al) {
                            System.out.println(obj);
                            } // displaying the training_program table to the
                             // coordinator..
                            break;

						}
						case 2: {

							// Date date1,date2;

							do {
								do {
									System.out.println("which one to modify?");
									id = kb.nextInt();
									b = coord.validate(id);
								} while (b == false);
								b = false;

								do {
									System.out
											.print("enter new course code:");
									cId = kb.nextInt();
									b = coord.validateCID(cId);
									if (b == false) {
										System.out
												.println("Please input valid course id...");
									}
								} while (b == false);
								do {
									System.out
											.println("enter new faculty code:");
									fId = kb.nextInt();
									kb.nextLine();
									b = coord.validateFID(fId);
									{
										System.out
												.println("Please input valid faculty id...");
									}
								} while (b == false);

								System.out.println("enter new start date:");
								String date = kb.nextLine();

								// try {
								// date1=new
								// SimpleDateFormat("dd/MM/yyyy").parse(date);
								// } catch (ParseException e) {
								//
								// e.printStackTrace();
								// }
								System.out.println("enter new end date");
								String date2 = kb.nextLine();
								// try {
								// date2=new
								// SimpleDateFormat("dd/MM/yyyy").parse(date);
								// }
								// catch (ParseException e) {
								//
								// e.printStackTrace();
								// }
								trainingProgram.setTrainingCode(id);
								trainingProgram.setCourseCode(cId);
								trainingProgram.setStartdate(date);
								trainingProgram.setEndDate(date2);
								trainingProgram.setFacultyCode(fId);
								result = coord.updateProgram(trainingProgram);
								if (result > 0) {
									System.out.println(result
											+ " record successfully updated");

								} else
									System.out.println("record not updated");
								System.out
										.println("do you want continue updation:");
								again = kb.next().trim().charAt(0);
							} while ((result > 0 && (again == 'y' || again == 'Y'))
									|| (result < 0 && (again == 'y' || again == 'Y')));
							break;

						}
						case 3: {
							do {
								do {
									System.out
											.println("enter new course code:");
									cId = kb.nextInt();
									b = coord.validateCID(cId);
								} while (b == false);
								do {
									System.out
											.println("enter new faculty code:");
									fId = kb.nextInt();
									kb.next();
									b = coord.validateFID(fId);
								} while (b == false);
								System.out.println("enter new start date:");
								String date = kb.nextLine();
								System.out.println("enter new end date");
								String date2 = kb.nextLine();
								trainingProgram.setCourseCode(cId);
								trainingProgram.setStartdate(date);
								trainingProgram.setEndDate(date2);
								trainingProgram.setFacultyCode(fId);
								insert = coord.addProgram(trainingProgram);
								if (insert == true) {
									System.out.println("new program added");
								} else {
									System.out.println("not added");
								}
								System.out
										.println("do you want continue adding program:");
								again = kb.next().trim().charAt(0);
							} while ((insert == true && (again == 'y' || again == 'Y'))
									|| (insert == false && (again == 'y' || again == 'Y')));
							break;
						}
						case 4: {
							do {
								do {
									System.out
											.println("enter a training Program to remove");
									id = kb.nextInt();
									b = coord.validate(id);
									if (b == false)
										System.out
												.println("There is no program whith the training ID "
														+ id
														+ " please enter correct ID:");
								} while (b == false);
								result = coord.removeProgram(id);
								if (result > 0) {
									System.out.println(result
											+ "program deleted..");
								} else {
									System.out.println("deletion failed!!");
								}
								System.out.println("do you want delete again:");
								again = kb.next().trim().charAt(0);
							} while ((result > 0 && (again == 'y' || again == 'Y'))
									|| (result < 0 && (again == 'y' || again == 'Y')));
						}
						case 5: {
							break;
						}
						default: {
							System.out.println("enter correct choice.");
						}
						}
						break;
					}while(choice!=5);
					}
					case 2: {
						al = coord.trainingMaintenance();
						for (TrainingProgram obj : al) {
							System.out.println(obj);
						}
						do {
							System.out.println("enter a participant ID");
							num = kb.next();
							if (service.checkInt(num) == false) {
								System.out
										.println("please input proper participant ID..");
							} else {
								pId = Integer.parseInt(num);
								if (service.validatePID(pId) == false)
									System.out
											.println("Participant ID not Exist...");
								else {
									System.out.println("Enter Training Code: ");
									num = kb.next();
									if (service.checkInt(num) == false) {
										System.out
												.println("please input proper trianing ID..");
									} else {
										tId = Integer.parseInt(num);
										Boolean b1 = service.validateTID(tId);
										if (b1 == false) {
											System.out
													.println("this training does not exist.");
										} else {
											enroll.setParticipantId(pId);
											enroll.setTrainingCode(tId);
											result = coord
													.enrollParticipant(enroll);
											if (result == 0) {
												System.out
														.println("enrollment failed. want to try again?");
												again = kb.next().trim()
														.charAt(0);
											} else {
												System.out
														.println("Participant enrolled successfully..");
												System.out
														.println("do you want to continue.");
												again = kb.next().trim()
														.charAt(0);
											}

										}

									}

								}
							}
						} while (again != 'n' || again != 'N');
					}
					case 3: {
						coord.viewFeedback();
					}
					case 4: {
						break;
					}
					default: {
						System.out.println("please enter correct choice");
					}
					}
				} while(choice!=4);
				break;
				
			}
			case "participant": {

				System.out.println("1. Feedback");
				System.out.println("2. Exit");

				choice = kb.nextInt();
				switch (choice) {
				case 1: {
					int overall = 0;
					int tRelevent = 0;
					int cDoubts = 0;
					int hExp = 0;
					int rateHSN = 0;
					do {

						do {
							System.out.println("enter training code:");
							id = kb.nextInt();
							if (participant.validate(id) == false)
								System.out
										.println("please input corrrect training code..");
						} while (participant.validate(id) == false);
						System.out
								.println("--------Overall Course Rating-------------");
						System.out
								.println("1. How would you rate the course you attended as an overall learning experience?(out of 1 to 5)");
						do {
							num = kb.next();
							if (service.checkInt(num) == false) {
								System.out.println("please input only number");
							} else {
								overall = Integer.parseInt(num);
							}
						} while (service.checkInt(num) == false);
						System.out.println("2. Number of clarified doubts:");
						do {
							num = kb.next();
							if (service.checkInt(num) == false) {
								System.out.println("please input only number");
							} else {
								cDoubts = Integer.parseInt(num);
							}
						} while (service.checkInt(num) == false);
						System.out.println("3. Rate: were the topics relevent");

						do {
							num = kb.next();
							if (service.checkInt(num) == false) {
								System.out.println("please input only number");
							} else {
								tRelevent = Integer.parseInt(num);
							}
						} while (service.checkInt(num) == false);
						System.out.println("4. Rate your Hands-on Experience");
						do {
							num = kb.next();
							if (service.checkInt(num) == false) {
								System.out.println("please input only number");
							} else {
								hExp = Integer.parseInt(num);
							}
						} while (service.checkInt(num) == false);
						System.out
								.println("5. Rate: Hardware/Software/Networking");
						do {
							num = kb.next();
							if (service.checkInt(num) == false) {
								System.out.println("please input only number");
							} else {
								rateHSN = Integer.parseInt(num);
							}
						} while (service.checkInt(num) == false);
						System.out
								.println("6. What are the views you find most valuable about this course?");
						String comments = kb.next();
						System.out
								.println("7. What suggestions do you have to improve the course?");
						String suggest = kb.next();
						fm.setComments(comments);
						fm.setFB_Clrfy_dbts(cDoubts);
						fm.setFB_Hnd_out(hExp);
						fm.setFB_Hw_Sw_Ntwrk(rateHSN);
						fm.setFB_Prs_comm(overall);
						fm.setFB_TM(tRelevent);
						fm.setParticipant_Id(eid);
						fm.setSuggestions(suggest);
						fm.setTraining_Code(id);
						result = participant.insertFeedback(fm);
						if (result == 0) {
							System.out.println("feedback submission failed..");
							System.out.println("try again?");
							again = kb.next().trim().charAt(0);
						} else {
							System.out.println("feedback submitted.");
							System.out.println("feedback another subject?");
							again = kb.next().trim().charAt(0);
						}

					} while (again == 'y' || again == 'Y');
					break;
				}
				case 2: {
					break;
				}
				}
				break;
			}
			}
		} while(true);

	}

}
