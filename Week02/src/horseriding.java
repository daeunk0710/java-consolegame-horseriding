import java.util.Scanner;
/*

 */
public class horseriding {
    public static void main(String[] args) {
        //입력 클래스 객체 생성
        Scanner sc = new Scanner(System.in);

        //변수 선언: 사용자명, 선택값, 쎄미 친밀도, 제국이 친밀도, 걸작이 친밀도, 기승자 숙련도, 운동량
        String name;
        int choice;
        int horseIntimacy1 = 0;
        int horseIntimacy2 = 0;
        int horseIntimacy3 = 0;
        int riderSkill = 0;
        int kcalBurned = 0;

        //인트로
        System.out.println("당신의 이름은 무엇인가요?");
        name = sc.nextLine();
        System.out.println(name + "님 안녕하세요. 승마하기 딱 좋은 날씨네요! 자 이제 마장으로 가볼까요?");
        System.out.println("==================================================================");
        System.out.println("승마장에 도착했습니다." +
                "\n당신의 선택은?\n");

        /*
        while (true) 무한루프 사용하여 선택지 외 값 입력시 무한 반복
        첫 번째 조건: 마루, 마구간, 장비 보관함
         */
        while (true) {
            System.out.println("1. 마루로 간다.\n2. 마구간으로 간다.\n3. 장비 보관함으로 간다.\n\n0. 종료");
            choice = sc.nextInt();

            // 0 입력시 무한루프 종료
            if (choice == 0) {
                break;

                //마루
            } else if (choice == 1) {
                System.out.println("동호회 사람들이 모여 있습니다." +
                        "\n당신의 선택은?\n");
                while (true) {
                    System.out.println("1. 동호회 사람들에게 인사한다.\n2. 가방을 내려둔다.\n3. 정수기에서 물을 마신다.\n" +
                            "4. 간식을 찾아본다.\n5. 의자에 앉는다.\n6. 승마 장갑을 챙긴다.\n\n0. 뒤로가기");
                    choice = sc.nextInt();

                    if (choice == 0) {
                        break;
                    } else if (choice == 1) {
                        System.out.println("안녕하세요!\n"+name+"씨 안녕하세요~ 오랜만에 뵙네요." +
                                "\n당신의 선택은?\n");
                        while (true) {
                            System.out.println("1. 사장님이 어디 계신지 여쭤본다. \n2. 오늘 날씨가 좋네요.\n3. 무슨 일로 모여 계세요?.\n\n0. 뒤로가기");
                            choice = sc.nextInt();

                            if (choice == 0) {
                                break;
                            } else if (choice == 1) {
                            } else if (choice == 2) {
                            } else if (choice == 3) {
                            } else {
                                System.out.println("선택지에 없는 항목입니다. 다시 선택해주세요.");
                            }
                        }
                    } else if (choice == 2) {
                        System.out.println("가방을 내려두었다." +
                                "\n당신의 선택은?\n");
                        while (true) {
                            System.out.println("1. 동호회 사람들에게 인사한다. \n2. 승마 장갑을 챙긴다.\n3. 돌아 나온다.\n\n0. 뒤로가기");
                            choice = sc.nextInt();

                            if (choice == 0) {
                                break;
                            } else if (choice == 1) {
                            } else if (choice == 2) {
                            } else if (choice == 3) {
                            } else {
                                System.out.println("선택지에 없는 항목입니다. 다시 선택해주세요.");
                            }
                        }
                    } else if (choice == 3) {
                        System.out.println("캬 시원하다! 갈증이 가신다." +
                                "\n당신의 선택은?\n");
                        while (true) {
                            System.out.println("1. 화장실에 간다. \n2. 승마 장갑을 챙긴다.\n3. 한 잔 더 마신다.\n\n0. 뒤로가기");
                            choice = sc.nextInt();

                            if (choice == 0) {
                                break;
                            } else if (choice == 1) {
                            } else if (choice == 2) {
                            } else if (choice == 3) {
                            } else {
                                System.out.println("선택지에 없는 항목입니다. 다시 선택해주세요.");
                            }
                        }
                    } else if (choice == 4) {
                        System.out.println("서랍장에 간식이 보이네요" +
                                "\n당신의 선택은?\n");
                        while (true) {
                            System.out.println("1. 컵라면을 꺼내 먹는다. \n2. 군고구마를 먹는다.\n3. 믹스 커피를 마신다.\n\n0. 뒤로가기");
                            choice = sc.nextInt();

                            if (choice == 0) {
                                break;
                            } else if (choice == 1) {
                            } else if (choice == 2) {
                            } else if (choice == 3) {
                            } else {
                                System.out.println("선택지에 없는 항목입니다. 다시 선택해주세요.");
                            }
                        }
                    } else if (choice == 5) {
                        System.out.println("의자에 앉았더니 저 멀리 실내 마장이 보이네요." +
                                "\n당신의 선택은?\n");
                        while (true) {
                            System.out.println("1. 실내 마장의 사람들을 구경한다. \n2. 동호회 사람들에게 인사한다.\n3. 하늘을 감상한다.\n4. 사진을 찍는다.\n\n0. 뒤로가기");
                            choice = sc.nextInt();

                            if (choice == 0) {
                                break;
                            } else if (choice == 1) {
                            } else if (choice == 2) {
                            } else if (choice == 3) {
                            } else if (choice == 4) {
                            } else {
                                System.out.println("선택지에 없는 항목입니다. 다시 선택해주세요.");
                            }
                        }
                    } else if (choice == 6) {
                        System.out.println("승마 장갑을 착용했습니다. 현재 착용한 장비는 승마 장갑입니다." +
                                "\n당신의 선택은?\n");
                        while (true) {
                            System.out.println("1. 동호회 사람들에게 인사한다. \n2. 가방을 내려둔다.\n3. 돌아 나온다.\n\n0. 뒤로가기");
                            choice = sc.nextInt();

                            if (choice == 0) {
                                break;
                            } else if (choice == 1) {
                            } else if (choice == 2) {
                            } else if (choice == 3) {
                            } else {
                                System.out.println("선택지에 없는 항목입니다. 다시 선택해주세요.");
                            }
                        }
                    } else {
                        System.out.println("선택지에 없는 항목입니다. 다시 선택해주세요.");
                    }
                }

                //마구간
            } else if (choice == 2) {
                System.out.println("코치님이 말을 돌보고 있네요" +
                        "\n당신의 선택은?\n");
                while (true) {
                    System.out.println("1. 코치님에게 인사한다.\n2. 말에게 다가간다.\n3. 원형 마장으로 간다.\n\n0. 뒤로가기");
                    choice = sc.nextInt();

                    if (choice == 0) {
                        break;
                    } else if (choice == 1) {
                        System.out.println("코치님 안녕하세요!\n" + name + "님 오셨어요?" +
                                "\n\n당신의 선택은?\n");
                        while (true) {
                            System.out.println("1. 사장님이 어디 계신지 여쭤본다. \n2. 코치님과 같이 말에게 먹이 주기.\n3. 마사 청소를 도와드린다.\n\n0. 뒤로가기");
                            choice = sc.nextInt();

                            if (choice == 0) {
                                break;
                            } else if (choice == 1) {
                            } else if (choice == 2) {
                            } else if (choice == 3) {
                            } else {
                                System.out.println("선택지에 없는 항목입니다. 다시 선택해주세요.");
                            }
                        }
                    } else if (choice == 2) {
                        System.out.println("세 마리 말이 있습니다. 어느 말과 친해지시겠어요?" +
                                "\n당신의 선택은?\n");
                        while (true) {
                            System.out.println("1. 쎄미\n2. 제국이\n3. 걸작이\n\n0. 뒤로가기");
                            choice = sc.nextInt();

                            if (choice == 0) {
                                break;
                            } else if (choice == 1) {
                                System.out.println("쎄미를 선택하셨군요. 말과 교감하며 친밀도를 높힐 수 있습니다." +
                                        "\n당신의 선택은?\n");
                                while (true) {
                                    System.out.println("1. 쓰다듬기. \n2. 간식 주기.\n3. 사진 찍기.\n4. 돌아 나온다.\n\n0. 뒤로가기");
                                    choice = sc.nextInt();

                                    if (choice == 0) {
                                        break;
                                    } else if (choice == 1) {
                                        horseIntimacy1 = horseIntimacy1 + 5;
                                        System.out.println("쎄미와의 친밀도가 5 상승했습니다.");
                                        System.out.println("현재 쎄미와의 친밀도는 " + horseIntimacy1 + "입니다");
                                    } else if (choice == 2) {
                                        horseIntimacy1 = horseIntimacy1 + 10;
                                        System.out.println("쎄미와의 친밀도가 10 상승했습니다.");
                                        System.out.println("현재 쎄미와의 친밀도는 " + horseIntimacy1 + "입니다");
                                    } else if (choice == 3) {
                                        horseIntimacy1 = horseIntimacy1 + 1;
                                        System.out.println("쎄미와의 친밀도가 1 상승했습니다.");
                                        System.out.println("현재 쎄미와의 친밀도는 " + horseIntimacy1 + "입니다");
                                    } else if (choice == 4) {
                                        System.out.println("마구간에서 나왔습니다. 어디로 갈까요?");
                                        while (true) {
                                            System.out.println("1. 원형 마장\n2. 마루\n3. 장비 보관함\n\n0. 뒤로가기");
                                            choice = sc.nextInt();

                                            if (choice == 0) {
                                                break;
                                            } else if (choice == 1) {
                                            } else if (choice == 2) {
                                            } else if (choice == 3) {
                                            } else {
                                                System.out.println("선택지에 없는 항목입니다. 다시 선택해주세요.");
                                            }
                                        }
                                    } else {
                                        System.out.println("선택지에 없는 항목입니다. 다시 선택해주세요.");
                                    }
                                }
                            } else if (choice == 2) {
                                System.out.println("제국이를 선택하셨군요. 말과 교감하며 친밀도를 높힐 수 있습니다." +
                                        "\n당신의 선택은?\n");
                                while (true) {
                                    System.out.println("1. 쓰다듬기. \n2. 간식 주기.\n3. 사진 찍기.\n4. 돌아 나온다.\n\n0. 뒤로가기");
                                    choice = sc.nextInt();

                                    if (choice == 0) {
                                        break;
                                    } else if (choice == 1) {
                                        horseIntimacy2 = horseIntimacy2 + 5;
                                        System.out.println("제국이와의 친밀도가 5 상승했습니다.");
                                        System.out.println("현재 제국이와의 친밀도는 " + horseIntimacy2 + "입니다");
                                    } else if (choice == 2) {
                                        horseIntimacy2 = horseIntimacy2 + 10;
                                        System.out.println("제국이와의 친밀도가 10 상승했습니다.");
                                        System.out.println("현재 제국이와의 친밀도는 " + horseIntimacy2 + "입니다");
                                    } else if (choice == 3) {
                                        horseIntimacy2 = horseIntimacy2 + 1;
                                        System.out.println("제국이와의 친밀도가 1 상승했습니다.");
                                        System.out.println("현재 제국이와의 친밀도는 " + horseIntimacy2 + "입니다");
                                    } else if (choice == 4) {
                                        System.out.println("마구간에서 나왔습니다. 어디로 갈까요?");
                                        while (true) {
                                            System.out.println("1. 원형 마장\n2. 마루\n3. 장비 보관함\n\n0. 뒤로가기");
                                            choice = sc.nextInt();

                                            if (choice == 0) {
                                                break;
                                            } else if (choice == 1) {
                                            } else if (choice == 2) {
                                            } else if (choice == 3) {
                                            } else {
                                                System.out.println("선택지에 없는 항목입니다. 다시 선택해주세요.");
                                            }
                                        }
                                    }
                                }
                            } else if (choice == 3) {
                                System.out.println("걸작이를 선택하셨군요. 말과 교감하며 친밀도를 높힐 수 있습니다." +
                                        "\n당신의 선택은?\n");
                                while (true) {
                                    System.out.println("1. 쓰다듬기. \n2. 간식 주기.\n3. 사진 찍기.\n4. 돌아 나온다.\n\n0. 뒤로가기");
                                    choice = sc.nextInt();

                                    if (choice == 0) {
                                        break;
                                    } else if (choice == 1) {
                                        horseIntimacy3 = horseIntimacy3 + 5;
                                        System.out.println("걸작이와의 친밀도가 5 상승했습니다.");
                                        System.out.println("현재 걸작이와의 친밀도는 " + horseIntimacy3 + "입니다");
                                    } else if (choice == 2) {
                                        horseIntimacy3 = horseIntimacy3 + 10;
                                        System.out.println("걸작이와의 친밀도가 10 상승했습니다.");
                                        System.out.println("현재 걸작이와의 친밀도는 " + horseIntimacy3 + "입니다");
                                    } else if (choice == 3) {
                                        horseIntimacy3 = horseIntimacy3 + 1;
                                        System.out.println("걸작이와의 친밀도가 1 상승했습니다.");
                                        System.out.println("현재 걸작이와의 친밀도는 " + horseIntimacy3 + "입니다");
                                    } else if (choice == 4) {
                                        System.out.println("마구간에서 나왔습니다. 어디로 갈까요?");
                                        while (true) {
                                            System.out.println("1. 원형 마장\n2. 마루\n3. 장비 보관함\n\n0. 뒤로가기");
                                            choice = sc.nextInt();

                                            if (choice == 0) {
                                                break;
                                            } else if (choice == 1) {
                                            } else if (choice == 2) {
                                            } else if (choice == 3) {
                                            } else {
                                                System.out.println("선택지에 없는 항목입니다. 다시 선택해주세요.");
                                            }
                                        }
                                    }
                                }
                            } else {
                                System.out.println("선택지에 없는 항목입니다. 다시 선택해주세요.");
                            }
                        }

                    } else if (choice == 3) {
                        System.out.println("사장님이 레슨을 하고 계시네요." +
                                "\n당신의 선택은?\n");
                        while (true) {
                            System.out.println("1. 사장님에게 인사한다. \n2. 돌아 나온다.\n\n0. 뒤로가기");
                            choice = sc.nextInt();

                            if (choice == 0) {
                                break;
                            } else if (choice == 1) {
                                System.out.println("어 "+name+"씨 왔어?" +
                                        "\n당신의 선택은?\n");
                                while (true) {
                                    System.out.println("1. 무슨 말을 탈지 여쭤본다.\n2. 레슨 모습을 지켜본다.\n3. 돌아 나온다.\n\n0. 뒤로가기");
                                    choice = sc.nextInt();

                                    if (choice == 0) {
                                        break;
                                    } else if (choice == 1) {
                                        System.out.println("무슨 말 타고 싶어요?" +
                                                "\n당신의 선택은?\n");
                                        while (true) {
                                            System.out.println("1. 쎄미\n2. 제국이\n3. 걸작이\n4. 추천을 부탁드린다.\n\n0. 뒤로가기");
                                            choice = sc.nextInt();

                                            if (choice == 0) {
                                                break;
                                            } else if (choice == 1) {
                                                System.out.println("쎄미가 선택되었습니다. 이제 장비를 착용하러 가볼까요?");
                                            } else if (choice == 2) {
                                                System.out.println("제국이가 선택되었습니다. 이제 장비를 착용하러 가볼까요?");
                                            } else if (choice == 3) {
                                                System.out.println("걸작이가 선택되었습니다. 이제 장비를 착용하러 가볼까요?");
                                            } else if (choice == 4) {
                                                if (riderSkill < 100) {
                                                    System.out.println("아직은 쎄미가 좋겠군. 장비 착용하고 마장으로 와~");
                                                } else {
                                                    if (horseIntimacy2 > horseIntimacy3) {
                                                        System.out.println("제국이랑 많이 친해졌지? 장비 착용하고 마장으로 와~");
                                                    } else {
                                                        System.out.println("오늘은 걸작이로 하자. 장비 착용하고 마장으로 와~");
                                                    }
                                                }
                                            }
                                            else {
                                                System.out.println("선택지에 없는 항목입니다. 다시 선택해주세요.");
                                            }
                                        }
                                    } else if (choice == 2) {
                                    } else if (choice == 3) {
                                    } else {
                                        System.out.println("선택지에 없는 항목입니다. 다시 선택해주세요.");
                                    }
                                }
                            } else if (choice == 2) {
                                System.out.println("사장님이 레슨을 하고 계시네요." +
                                        "\n당신의 선택은?\n");
                                while (true) {
                                    System.out.println("1. 사장님에게 인사한다. \n2. 돌아 나온다.\n\n0. 뒤로가기");
                                    choice = sc.nextInt();

                                    if (choice == 0) {
                                        break;
                                    } else if (choice == 1) {
                                    } else if (choice == 2) {
                                    } else if (choice == 3) {
                                    } else {
                                        System.out.println("선택지에 없는 항목입니다. 다시 선택해주세요.");
                                    }
                                }
                            } else {
                                System.out.println("선택지에 없는 항목입니다. 다시 선택해주세요.");
                            }
                        }
                    } else {
                        System.out.println("선택지에 없는 항목입니다. 다시 선택해주세요.");
                    }
                }

                //장비 보관함
            } else if (choice == 3) {
                System.out.println("아무도 없는 공간에 장비들이 쌓여 있습니다." +
                        "\n당신의 선택은?\n");
                while (true) {
                    System.out.println("1. 사물함으로 간다. \n2. 거울 옆 승마 모자가 있는 서랍장으로 간다.\n3. 챕이 있는 안쪽 서랍장으로 간다.\n4. 가방을 내려둔다.\n\n0. 뒤로가기");
                    choice = sc.nextInt();

                    if (choice == 0) {
                        break;

                        //사물함
                    } else if (choice == 1) {
                        System.out.println("개인 장비들이 모여 있네요.\n" + name + "님의 개인 장비를 찾아볼까요?\n");
                        while (true) {
                            System.out.println("1. 개인 장비를 발견했다.\n2. 개인 장비를 발견하지 못했다.\n\n0. 뒤로가기");
                            choice = sc.nextInt();

                            if (choice == 0) {
                                break;

                                //개인 장비가 있는 경우
                            } else if (choice == 1) {
                                System.out.println("가방 안에 승마 모자, 승마 장갑, 승마 부츠가 있습니다.\n당신의 선택은?");
                                while (true) {
                                    System.out.println("1. 승마 모자를 착용한다.\n2. 승마 장갑을 착용한다.\n3. 승마 부츠를 착용한다.\n\n0. 뒤로가기");
                                    choice = sc.nextInt();
                                    if (choice == 0) {
                                        break;

                                        //승마 모자 착용
                                    } else if (choice == 1) {
                                        System.out.println("승마 모자를 착용했습니다. 현재 착용한 장비는 승마 모자입니다.\n당신의 선택은?");
                                        while (true) {
                                            System.out.println("1. 승마 장갑을 착용한다.\n2. 승마 부츠를 착용한다.\n\n0. 뒤로가기");
                                            choice = sc.nextInt();

                                            if (choice == 0) {
                                                break;
                                            } else if (choice == 1) {
                                                System.out.println("승마 장갑을 착용했습니다. 현재 착용한 장비는 승마 모자, 승마 장갑입니다.\n당신의 선택은?");
                                                while (true) {
                                                    System.out.println("1. 승마 부츠를 착용한다.\n2. 돌아 나간다.\n\n0. 뒤로가기");
                                                    choice = sc.nextInt();
                                                    if (choice == 0) {
                                                        break;
                                                    } else if (choice == 1) {
                                                        System.out.println("모든 장비를 착용하셨군요! 이제 기승할 말을 선택해봅시다.\n당신의 선택은?");
                                                        while (true) {
                                                            System.out.println("1. 마루로 간다. \n2. 마구간으로 간다.\n3. 화장실에 간다.\n\n0. 뒤로가기");
                                                            choice = sc.nextInt();

                                                            if (choice == 0) {
                                                                break;
                                                            } else if (choice == 1) {
                                                            } else if (choice == 2) {
                                                            } else if (choice == 3) {
                                                            } else {
                                                                System.out.println("선택지에 없는 항목입니다. 다시 선택해주세요.");
                                                            }
                                                        }
                                                    } else if (choice == 2) {
                                                        System.out.println("부츠를 착용해야 말을 탈 수 있습니다.\n당신의 선택은?");
                                                        while (true) {
                                                            System.out.println("1. 승마 부츠를 착용한다. \n2. 돌아 나간다.\n\n0. 뒤로가기");
                                                            choice = sc.nextInt();

                                                            if (choice == 0) {
                                                                break;
                                                            } else if (choice == 1) {
                                                            } else if (choice == 2) {
                                                            } else {
                                                                System.out.println("선택지에 없는 항목입니다. 다시 선택해주세요.");
                                                            }
                                                        }
                                                    } else {
                                                        System.out.println("선택지에 없는 항목입니다. 다시 선택해주세요.");
                                                    }
                                                }
                                            } else if (choice == 2) {

                                                System.out.println("승마 부츠를 착용했습니다. 현재 착용한 장비는 승마 모자, 승마 부츠입니다.\n당신의 선택은?");
                                                while (true) {
                                                    System.out.println("1. 승마 장갑을 착용한다.\n2. 돌아 나간다.\n\n0. 뒤로가기");
                                                    choice = sc.nextInt();

                                                    if (choice == 0) {
                                                        break;
                                                    } else if (choice == 1) {
                                                        System.out.println("모든 장비를 착용하셨군요! 이제 기승할 말을 선택해봅시다.\n당신의 선택은?");
                                                        while (true) {
                                                            System.out.println("1. 마루로 간다. \n2. 마구간으로 간다.\n3. 화장실에 간다.\n\n0. 뒤로가기");
                                                            choice = sc.nextInt();

                                                            if (choice == 0) {
                                                                break;
                                                            } else if (choice == 1) {
                                                            } else if (choice == 2) {
                                                            } else if (choice == 3) {
                                                            } else {
                                                                System.out.println("선택지에 없는 항목입니다. 다시 선택해주세요.");
                                                            }
                                                        }
                                                    } else if (choice == 2) {
                                                        System.out.println("장갑을 착용하지 않으면 손이 다칠 수 있어요.\n당신의 선택은?");
                                                        while (true) {
                                                            System.out.println("1. 승마 장갑을 착용한다. \n2. 돌아 나간다.\n\n0. 뒤로가기");
                                                            choice = sc.nextInt();
                                                            if (choice == 0) {
                                                                break;
                                                            } else if (choice == 1) {
                                                            } else if (choice == 2) {
                                                            } else {
                                                                System.out.println("선택지에 없는 항목입니다. 다시 선택해주세요.");
                                                            }
                                                        }
                                                    } else {
                                                        System.out.println("선택지에 없는 항목입니다. 다시 선택해주세요.");
                                                    }
                                                }
                                            }
                                        }

                                        //승마 장갑 착용
                                    } else if (choice == 2) {
                                        System.out.println("승마 장갑을 착용했습니다. 현재 착용한 장비는 승마 장갑입니다.\n당신의 선택은?");
                                        while (true) {
                                            System.out.println("1. 승마 모자를 착용한다.\n2. 승마 부츠를 착용한다.\n\n0. 뒤로가기");
                                            choice = sc.nextInt();

                                            if (choice == 0) {
                                                break;
                                            } else if (choice == 1) {
                                                System.out.println("승마 모자를 착용했습니다. 현재 착용한 장비는 승마 모자, 승마 장갑입니다.\n당신의 선택은?");
                                                while (true) {
                                                    System.out.println("1. 승마 부츠를 착용한다.\n2. 돌아 나간다.\n\n0. 뒤로가기");
                                                    choice = sc.nextInt();
                                                    if (choice == 0) {
                                                        break;
                                                    } else if (choice == 1) {
                                                        System.out.println("모든 장비를 착용하셨군요! 이제 기승할 말을 선택해봅시다.\n당신의 선택은?");
                                                        while (true) {
                                                            System.out.println("1. 마루로 간다. \n2. 마구간으로 간다.\n3. 화장실에 간다.\n\n0. 뒤로가기");
                                                            choice = sc.nextInt();

                                                            if (choice == 0) {
                                                                break;
                                                            } else if (choice == 1) {
                                                            } else if (choice == 2) {
                                                            } else if (choice == 3) {
                                                            } else {
                                                                System.out.println("선택지에 없는 항목입니다. 다시 선택해주세요.");
                                                            }
                                                        }
                                                    } else if (choice == 2) {
                                                        System.out.println("부츠를 착용해야 말을 탈 수 있습니다.\n당신의 선택은?");
                                                        while (true) {
                                                            System.out.println("1. 승마 부츠를 착용한다. \n2. 돌아 나간다.\n\n0. 뒤로가기");
                                                            choice = sc.nextInt();

                                                            if (choice == 0) {
                                                                break;
                                                            } else if (choice == 1) {
                                                            } else if (choice == 2) {
                                                            } else {
                                                                System.out.println("선택지에 없는 항목입니다. 다시 선택해주세요.");
                                                            }
                                                        }
                                                    } else {
                                                        System.out.println("선택지에 없는 항목입니다. 다시 선택해주세요.");
                                                    }
                                                }
                                            } else if (choice == 2) {

                                                System.out.println("승마 부츠를 착용했습니다. 현재 착용한 장비는 승마 장갑, 승마 부츠입니다.\n당신의 선택은?");
                                                while (true) {
                                                    System.out.println("1. 승마 모자을 착용한다.\n2. 돌아 나간다.\n\n0. 뒤로가기");
                                                    choice = sc.nextInt();

                                                    if (choice == 0) {
                                                        break;
                                                    } else if (choice == 1) {
                                                        System.out.println("모든 장비를 착용하셨군요! 이제 기승할 말을 선택해봅시다.\n당신의 선택은?");
                                                        while (true) {
                                                            System.out.println("1. 마루로 간다. \n2. 마구간으로 간다.\n3. 화장실에 간다.\n\n0. 뒤로가기");
                                                            choice = sc.nextInt();

                                                            if (choice == 0) {
                                                                break;
                                                            } else if (choice == 1) {
                                                            } else if (choice == 2) {
                                                            } else if (choice == 3) {
                                                            } else {
                                                                System.out.println("선택지에 없는 항목입니다. 다시 선택해주세요.");
                                                            }
                                                        }
                                                    } else if (choice == 2) {
                                                        System.out.println("승마 모자를 착용하지 않으면 기승할 수 없습니다.\n당신의 선택은?");
                                                        while (true) {
                                                            System.out.println("1. 승마 모자를 착용한다. \n2. 돌아 나간다.\n\n0. 뒤로가기");
                                                            choice = sc.nextInt();
                                                            if (choice == 0) {
                                                                break;
                                                            } else if (choice == 1) {
                                                            } else if (choice == 2) {
                                                            } else {
                                                                System.out.println("선택지에 없는 항목입니다. 다시 선택해주세요.");
                                                            }
                                                        }
                                                    } else {
                                                        System.out.println("선택지에 없는 항목입니다. 다시 선택해주세요.");
                                                    }
                                                }
                                            }
                                        }
                                        //승마 부츠 착용
                                    } else if (choice == 3) {
                                        System.out.println("승마 부츠를 착용했습니다. 현재 착용한 장비는 승마 부츠입니다.\n당신의 선택은?");
                                        while (true) {
                                            System.out.println("1. 승마 장갑을 착용한다.\n2. 승마 모자를 착용한다.\n\n0. 뒤로가기");
                                            choice = sc.nextInt();

                                            if (choice == 0) {
                                                break;
                                            } else if (choice == 1) {
                                                System.out.println("승마 장갑을 착용했습니다. 현재 착용한 장비는 승마 부츠, 승마 장갑입니다.\n당신의 선택은?");
                                                while (true) {
                                                    System.out.println("1. 승마 모자를 착용한다.\n2. 돌아 나간다.\n\n0. 뒤로가기");
                                                    choice = sc.nextInt();
                                                    if (choice == 0) {
                                                        break;
                                                    } else if (choice == 1) {
                                                        System.out.println("모든 장비를 착용하셨군요! 이제 기승할 말을 선택해봅시다.\n당신의 선택은?");
                                                        while (true) {
                                                            System.out.println("1. 마루로 간다. \n2. 마구간으로 간다.\n3. 화장실에 간다.\n\n0. 뒤로가기");
                                                            choice = sc.nextInt();

                                                            if (choice == 0) {
                                                                break;
                                                            } else if (choice == 1) {
                                                            } else if (choice == 2) {
                                                            } else if (choice == 3) {
                                                            } else {
                                                                System.out.println("선택지에 없는 항목입니다. 다시 선택해주세요.");
                                                            }
                                                        }
                                                    } else if (choice == 2) {
                                                        System.out.println("승마 모자를 착용하지 않으면 기승할 수 없습니다.\n당신의 선택은?");
                                                        while (true) {
                                                            System.out.println("1. 승마 모자를 착용한다. \n2. 돌아 나간다.\n\n0. 뒤로가기");
                                                            choice = sc.nextInt();

                                                            if (choice == 0) {
                                                                break;
                                                            } else if (choice == 1) {
                                                            } else if (choice == 2) {
                                                            } else {
                                                                System.out.println("선택지에 없는 항목입니다. 다시 선택해주세요.");
                                                            }
                                                        }
                                                    } else {
                                                        System.out.println("선택지에 없는 항목입니다. 다시 선택해주세요.");
                                                    }
                                                }
                                            } else if (choice == 2) {
                                                System.out.println("승마 모자를 착용했습니다. 현재 착용한 장비는 승마 부츠, 승마 모자입니다.\n당신의 선택은?");
                                                while (true) {
                                                    System.out.println("1. 승마 장갑을 착용한다.\n2. 돌아 나간다.\n\n0. 뒤로가기");
                                                    choice = sc.nextInt();

                                                    if (choice == 0) {
                                                        break;
                                                    } else if (choice == 1) {
                                                        System.out.println("모든 장비를 착용하셨군요! 이제 기승할 말을 선택해봅시다.\n당신의 선택은?");
                                                        while (true) {
                                                            System.out.println("1. 마루로 간다. \n2. 마구간으로 간다.\n3. 화장실에 간다.\n\n0. 뒤로가기");
                                                            choice = sc.nextInt();

                                                            if (choice == 0) {
                                                                break;
                                                            } else if (choice == 1) {
                                                            } else if (choice == 2) {
                                                            } else if (choice == 3) {
                                                            } else {
                                                                System.out.println("선택지에 없는 항목입니다. 다시 선택해주세요.");
                                                            }
                                                        }
                                                    } else if (choice == 2) {
                                                        System.out.println("장갑을 착용하지 않으면 손이 다칠 수 있어요.\n당신의 선택은?");
                                                        while (true) {
                                                            System.out.println("1. 승마 장갑을 착용한다. \n2. 돌아 나간다.\n\n0. 뒤로가기");
                                                            choice = sc.nextInt();

                                                            if (choice == 0) {
                                                                break;
                                                            } else if (choice == 1) {
                                                            } else if (choice == 2) {
                                                            } else {
                                                                System.out.println("선택지에 없는 항목입니다. 다시 선택해주세요.");
                                                            }
                                                        }
                                                    } else {
                                                        System.out.println("선택지에 없는 항목입니다. 다시 선택해주세요.");
                                                    }
                                                }
                                            }
                                        }
                                    } else {
                                        System.out.println("선택지에 없는 항목입니다. 다시 선택해주세요.");
                                    }
                                }

                                //개인 장비 없는 경우
                            } else if (choice == 2) {
                                System.out.println("괜찮습니다. 공용 장비를 찾아봅시다.\n이제 어떻게 할까요?");
                                while (true) {
                                    System.out.println("1. 가방을 내려둔다. \n2. 거울 옆 서랍장으로 간다 .\n3. 안쪽 서랍장으로 간다.\n\n0. 뒤로가기");
                                    choice = sc.nextInt();

                                    if (choice == 0) {
                                        break;
                                    } else if (choice == 1) {
                                    } else if (choice == 2) {
                                    } else if (choice == 3) {
                                    } else {
                                        System.out.println("선택지에 없는 항목입니다. 다시 선택해주세요.");
                                    }
                                }
                            } else {
                                System.out.println("선택지에 없는 항목입니다. 다시 선택해주세요.");
                            }
                        }

                        //승마 모자가 있는 서랍장: 낡은 승마 모자 A, B & 헬멧 A, B, C, D
                    } else if (choice == 2) {
                        System.out.println("크기와 모양이 제각각인 승마 모자들이 있네요" +
                                "\n당신의 선택은?\n");
                        while (true) {
                            System.out.println("1. 낡은 승마 모자 A\n2. 낡은 승마 모자 B\n3. 헬멧 A\n4. 헬멧 B\n5. 헬멧 C\n6. 헬멧 D\n\n0. 뒤로가기");
                            choice = sc.nextInt();

                            if (choice == 0) {
                                break;
                            } else if (choice == 1) {
                                System.out.println("사이즈가 작습니다.");
                            } else if (choice == 2) {
                                System.out.println("사이즈가 맞습니다.");
                            } else if (choice == 3) {
                                System.out.println("사이즈 조절이 되지 않습니다.");
                            } else if (choice == 4) {
                                System.out.println("사이즈가 작습니다.");
                            } else if (choice == 5) {
                                System.out.println("사이즈가 맞습니다." +
                                        "\n당신의 선택은?\n");
                                while (true) {
                                    System.out.println("1. 모자를 착용한다.\n2. 다른 모자를 둘러본다\n\n0. 뒤로가기");
                                    choice = sc.nextInt();

                                    if (choice == 0) {
                                        break;
                                    } else if (choice == 1) {
                                        System.out.println("승마 모자를 착용했습니다. 현재 착용한 장비는 승마 모자입니다." +
                                                "\n당신의 선택은?\n");
                                        while (true) {
                                            System.out.println("1. 챕이 있는 안쪽 서랍장으로 간다.\n2. 돌아 나간다.\n\n0. 뒤로가기");
                                            choice = sc.nextInt();

                                            if (choice == 0) {
                                                break;
                                            } else if (choice == 1) {

                                            } else if (choice == 2) {
                                                break;
                                            } else {
                                                System.out.println("선택지에 없는 항목입니다. 다시 선택해주세요.");
                                            }
                                        }
                                    } else if (choice == 6) {
                                        System.out.println("사이즈가 맞습니다." +
                                                "\n당신의 선택은?\n");
                                        while (true) {
                                            System.out.println("1. 모자를 착용한다.\n2. 다른 모자를 둘러본다\n\n0. 뒤로가기");
                                            choice = sc.nextInt();

                                            if (choice == 0) {
                                                break;
                                            } else if (choice == 1) {
                                                System.out.println("승마 모자를 착용했습니다. 현재 착용한 장비는 승마 모자입니다." +
                                                        "\n당신의 선택은?\n");
                                                while (true) {
                                                    System.out.println("1. 챕이 있는 안쪽 서랍장으로 간다.\n2. 돌아 나간다.\n\n0. 뒤로가기");
                                                    choice = sc.nextInt();
                                                    if (choice == 0) {
                                                        break;
                                                    } else if (choice == 1) {

                                                    } else if (choice == 2) {
                                                        break;
                                                    } else {
                                                        System.out.println("선택지에 없는 항목입니다. 다시 선택해주세요.");
                                                    }
                                                }
                                            } else {
                                                System.out.println("선택지에 없는 항목입니다. 다시 선택해주세요.");
                                            }
                                        }

                                        //챕이 있는 서랍장
                                    } else if (choice == 3) {
                                        System.out.println("서랍장에 챕이 마구 섞여 있습니다." +
                                                "\n당신의 선택은?\n");
                                        while (true) {
                                            System.out.println("1. 짝을 맞춰 정리한다. \n2. 멀쩡해 보이는 두 개를 고른다.\n\n0. 뒤로가기");
                                            choice = sc.nextInt();

                                            if (choice == 0) {
                                                break;
                                            } else if (choice == 1) {
                                            } else if (choice == 2) {
                                            } else if (choice == 3) {
                                            } else {
                                                System.out.println("선택지에 없는 항목입니다. 다시 선택해주세요.");
                                            }
                                        }

                                        //가방 내려두기
                                    } else if (choice == 4) {
                                        System.out.println("아무도 없는 공간에 장비들이 쌓여 있습니다." +
                                                "\n당신의 선택은?\n");
                                        while (true) {
                                            System.out.println("1. 동호회 사람들에게 인사한다. \n2. 가방을 내려둔다.\n3. 정수기에서 물을 마신다.\n\n0. 뒤로가기");
                                            choice = sc.nextInt();

                                            if (choice == 0) {
                                                break;
                                            } else if (choice == 1) {
                                            } else if (choice == 2) {
                                            } else if (choice == 3) {
                                            } else {
                                                System.out.println("선택지에 없는 항목입니다. 다시 선택해주세요.");
                                            }
                                        }
                                    } else {
                                        System.out.println("선택지에 없는 항목입니다. 다시 선택해주세요.");
                                    }
                                }

                            } else {
                                System.out.println("선택지에 없는 항목입니다. 다시 선택해주세요.");
                            }
                        }
                    }
                }
            }
        }
    }
}

