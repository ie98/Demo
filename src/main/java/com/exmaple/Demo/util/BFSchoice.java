package com.exmaple.Demo.util;
import com.exmaple.Demo.dto.BFSChoiceResult;
import com.exmaple.Demo.dto.Point;
import com.exmaple.Demo.dto.RecommendSit;
import com.exmaple.Demo.model.Chair;
import com.exmaple.Demo.model.DiningTable;

import java.util.ArrayList;
import java.util.List;

public class BFSchoice {

    private Point[][] Points = new Point[144][144];
    private int[][] prototype = new int[6][24];
    private int[] temp = new int[144];
    private Chair[][] chairs = new Chair[6][24];

    public List<Chair> BFS(List<DiningTable> tables, int peopleNumber) {
//        System.out.println(System.currentTimeMillis());
        createChairs(tables);
        BFSChoiceResult[] bfsChoiceResults = bfsChoice(tables, peopleNumber);
//        System.out.println("length=" + bfsChoiceResults.length);
//        for (int i = 0; i < bfsChoiceResults.length ; i++) {
//            System.out.println("第"+i+"个选择："+bfsChoiceResults[i].getAllLength());
//        }
        int min = bfsChoiceResults[0].getAllLength();
        int index = 0;
        for (int i = 0; i < bfsChoiceResults.length; i++) {
            if (min > bfsChoiceResults[i].getAllLength() && bfsChoiceResults[i].getAllLength() != 0) {
                min = bfsChoiceResults[i].getAllLength();
                index = i;
            }
//
        }
//        System.out.println(bfsChoiceResults[index].getAllLength());
        List<Chair> chairList = new ArrayList<Chair>();
        int row = 0;
        int col = 0;
        for (int i = 0; i < peopleNumber; i++) {
            row = (((bfsChoiceResults[index].location[i]) / 24));
            col = (((bfsChoiceResults[index].location[i]) % 24));
//            System.out.printf("%3d %3d ;", row,col);
            chairList.add(chairs[row][col]);

        }

//        for (int i = 0; i < chairList.size(); i++) {
//            System.out.println(chairList.get(i).getIntable() + "-" + chairList.get(i).getChairnumber());
//        }
//        System.out.println(System.currentTimeMillis());
        return chairList;

    }


    private void createMatrix() {
        for (int i = 0; i < 144; i++) {
            for (int j = 0; j < 144; j++) {
                Points[i][j] = new Point();
            }
        }
    }

    public BFSChoiceResult[] bfsChoice(List<DiningTable> tables, int peopleNumber) {
        this.createMatrix();
        RecommendSit[] recommendSit = new RecommendSit[peopleNumber];//存放单次推荐位置
        for (int i = 0; i < peopleNumber; i++) {
            recommendSit[i] = new RecommendSit();
        }
//        recommendSit[0].setSitNumber(5);
//        System.out.println(recommendSit[0].getSitNumber());
        BFSChoiceResult[] result = new BFSChoiceResult[144]; //存放总推荐位置
        Point[] tempInFun1 = new Point[144];
        for (int i = 0; i < 144; i++) {
            tempInFun1[i] = new Point();
            result[i] = new BFSChoiceResult();
            result[i].setLocation(new int[peopleNumber]);
        }
        RecommendSit[][] tempInFun2 = new RecommendSit[peopleNumber - 1][peopleNumber - 1]; //存放推荐位置的比较数据
        for (int i = 0; i < peopleNumber - 1; i++) {
            for (int j = 0; j < peopleNumber - 1; j++) {
                tempInFun2[i][j] = new RecommendSit();
            }
        }
        int sitIndex = 0;
        toCharArray(tables);
//        for (int i = 0; i < 144; i++) {
//            for (int j = 0; j < 144; j++) {
//                System.out.printf("%5d + %4d", Points[i][j].getDistance(), Points[i][j].getLocation());
//            }
//            System.out.println();
//        }
        int result_index = 0;
        for (int i = 0; i < 144; i++) {
//            System.out.println("----------------------------第"+i+"个-----------------------------");
            if (temp[i] != 0) {
                for (int l = 0; l <peopleNumber -1 ; l++) {//重置tempInFun2
                    for (int m = 0; m < peopleNumber -1 ; m++) {
                        tempInFun2[l][m].setUse(true);
                        tempInFun2[l][m].setSitNumber(0);
                        tempInFun2[l][m].setDistance(999); //防止点数过少使得出现空余点距离为0，反复使用
                    }
                }

                for (int j = 0; j <peopleNumber ; j++) {//重置recommentSit
                    recommendSit[j].setDistance(0);
                    recommendSit[j].setSitNumber(0);
                    recommendSit[j].setUse(true);
                }
                recommendSit[0].setSitNumber(i);//第一个点
                recommendSit[0].setDistance(0);
                result[result_index].setAllLength(0);
                result[result_index].location[0] = i;
                int star = i;  //新的起点
                for (int k = 1; k < peopleNumber; k++) {
                    for (int m = 0; m < 144; m++) {
                        tempInFun1[m].setDistance(0);
                        tempInFun1[m].setLocation(m);
                    }
                    for (int j = 0; j < 144; j++) {   //该点总长赋值
                        tempInFun1[j].setDistance(Points[star][j].getDistance());
                        for (int l = 0; l < k - 1; l++) {
                            if (recommendSit[l].getSitNumber() == j) { //该点是否已经选择过 ，是则置零，表示找不到并退出
                                tempInFun1[j].setDistance(0);
                                break;
                            } else {
                                tempInFun1[j].setDistance(tempInFun1[j].getDistance() + Points[j][recommendSit[l].getSitNumber()].getDistance());
                            }
                        }
                    }
                    tempInFun1[recommendSit[k - 1].getSitNumber()].setDistance(0);
                    maopaoSort.mpSort(tempInFun1); //排序
//                    System.out.println("排序后:");
//                    for (int m = 0; m < 144; m++)
//                        System.out.printf("%3d", tempInFun1[m].getDistance());
//                    等待优化
                    int index = 0;
                    for (int j = 0; j < 144; j++) {//寻找最近peopleNumber-1个点的位置和总长
                        if (tempInFun1[j].getDistance() != 0) {
                            tempInFun2[k - 1][index].setDistance(tempInFun1[j].getDistance());
                            tempInFun2[k - 1][index].setSitNumber(tempInFun1[j].getLocation());
//                            System.out.print("第" + index + "个点总距离：" + tempInFun1[j].getDistance());
                            index++;
                            if (index == peopleNumber - 1)
                                break;
                        }
                    }
//                    System.out.println("");
//                    for (int m = 0; m < peopleNumber - 1; m++) {
//                        System.out.printf("%5d", tempInFun2[k - 1][m].getDistance());
//                    }

                    RecommendSit minDistance = new RecommendSit();
                    minDistance.setSitNumber(tempInFun2[k - 1][0].getSitNumber());
                    minDistance.setDistance(tempInFun2[k - 1][0].getDistance());
                    int row = k - 1;
                    int col = 0;
                    for (int mincostSit = 0; mincostSit < k; mincostSit++) { //从先前所有数据中寻找总距离最小的点
                        //    if (mincostSit == k - 1) break;
                        for (int n = 0; n < peopleNumber - 1; n++) {
                            if (tempInFun2[mincostSit][n].getUse() == true) {
                                if (tempInFun2[mincostSit][n].getDistance() <= minDistance.getDistance()) {
                                    minDistance.setSitNumber(tempInFun2[mincostSit][n].getSitNumber());
                                    minDistance.setDistance(tempInFun2[mincostSit][n].getDistance());
                                    row = mincostSit;
                                    col = n;
//                                    System.out.println("进入if");
                                }
                            }
                        }
                    }
//                    System.out.println("当前选择" + tempInFun2[row][col].getSitNumber());
//                    System.out.println("当前选择" + minDistance.getSitNumber());
//                    System.out.println(row + " " + col);
                    tempInFun2[row][col].setUse(false);
                    recommendSit[k].setSitNumber(minDistance.getSitNumber());
                    recommendSit[k].setDistance(minDistance.getDistance());
                    star = tempInFun2[row][col].getSitNumber();

                    //更新数据
                    for (int j = 0; j < k; j++) {
                        for (int n = 0; n < peopleNumber - 1; n++) {
                            if (tempInFun2[j][n].getSitNumber() == star)
                                tempInFun2[j][n].setUse(false);
                            else
                                tempInFun2[j][n].setDistance(tempInFun2[j][n].getDistance() + Points[tempInFun2[j][n].getSitNumber()][star].getDistance());
                        }
                    }
//                    for (int a = 0; a < peopleNumber - 1; a++) {
//                        for (int j = 0; j < peopleNumber - 1; j++) {
//                            System.out.print("位置:" + tempInFun2[a][j].getSitNumber() + " " + "距离:" + tempInFun2[a][j].getDistance() + " " + "use:" + tempInFun2[a][j].getUse() + " ;");
//                        }
//                        System.out.println("");
//                    }

                }
                for (int j = 1; j < peopleNumber; j++) {
                    result[result_index].setAllLength(recommendSit[j].getDistance() + result[result_index].getAllLength());
                    result[result_index].location[j] = recommendSit[j].getSitNumber();
                }
                result_index++;

            }

        }

//        for (int i = 0; i < peopleNumber; i++) {
//            System.out.println(recommendSit[i].toString());
//
//        }
//        for (int i = 0; i <result.length ; i++) {
//            for (int j = 0; j < peopleNumber; j++) {
//                System.out.printf("%3d",result[i].location[j]);
//            }
//            System.out.println(result[i].getAllLength());
//        }


        return result;
    }

    public void toCharArray(List<DiningTable> tables) {
        int size = tables.size();
        int k = -2;
        for (int i = 0; i < size; i++) {
            if (i % 8 == 0) k += 2;
            for (int j = 0; j < 6; j++) {
                if (j < 3)
                    prototype[k][(i * 3 + j) % 24] = (tables.get(i).getChairs().get(j).getEmpty() == true) ? 1 : 0;

                else
                    prototype[k + 1][(i * 3 + j - 3) % 24] = (tables.get(i).getChairs().get(j).getEmpty() == true) ? 1 : 0;
            }
        }
        for (int i = 0; i < 6; i++) {
            for (int j = 0; j < 24; j++) {
//                System.out.print("  " + prototype[i][j]);
                temp[i * 24 + j] = prototype[i][j];
            }

//            System.out.println("");
        }
        for (int i = 0; i < 144; i++) {
            if (temp[i] != 0) {
                for (int j = i; j < 144; j++) {
                    if (i != j && temp[j] != 0)
                        if (j % 24 > i % 24)
                            Points[i][j].setDistance((difference(j / 24, i / 24)) + (j % 24 - i % 24)); //横向差值 加上纵向差值 注意 横向差值的正负
                        else
                            Points[i][j].setDistance((difference(j / 24, i / 24)) + (i % 24 - j % 24));

                    else
                        Points[i][j].setDistance(0);
                    Points[i][j].setLocation(j);
                }

            }
//            else {
//                for (int j = i ; j < 144; j++) {
//                    matrix[i][j].setDistance(0);
//                }
//            }
            for (int j = 0; j < i; j++) {
                Points[i][j].setDistance(Points[j][i].getDistance());
                Points[i][j].setLocation(j);
            }
        }

    }

    public void createChairs(List<DiningTable> tables) { //创建映射表
        int size = tables.size();
        for (int i = 0; i < 6; i++) {
            for (int j = 0; j < 24; j++) {
                chairs[i][j] = new Chair();
            }
        }
        int k = -2;
        for (int i = 0; i < size; i++) {
            if (i % 8 == 0) k += 2;
            for (int j = 0; j < 6; j++) {
                if (j < 3) {
                    chairs[k][(i * 3 + j) % 24].setChairnumber(tables.get(i).getChairs().get(j).getChairnumber());
                    chairs[k][(i * 3 + j) % 24].setIntable(tables.get(i).getChairs().get(j).getIntable());
                } else {
                    chairs[k + 1][(i * 3 + j - 3) % 24].setChairnumber(tables.get(i).getChairs().get(j).getChairnumber());
                    chairs[k + 1][(i * 3 + j - 3) % 24].setIntable(tables.get(i).getChairs().get(j).getIntable());
                }
            }
        }
    }

    public int difference(int j, int i) {
        int res = 0;
        if (j - i == 1) {
                if (i % 2 == 0) res = 1;
                if (i % 2 == 1) res = 2;
        } else if (j - i == 2) {
            res = 3;
        } else if (j - i == 3) {
            if (i == 1) res = 5;
            else
                res = 4;
        } else if (j - i == 4) {
            res = 6;
        } else if (j - i == 5) {
            res = 7;
        }
        return res;

    }
}
