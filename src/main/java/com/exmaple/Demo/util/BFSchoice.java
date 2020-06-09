package com.exmaple.Demo.util;

import com.exmaple.Demo.dto.BFSChoiceResult;
import com.exmaple.Demo.dto.Point;
import com.exmaple.Demo.dto.RecommendSit;
import com.exmaple.Demo.model.Chair;
import com.exmaple.Demo.model.DiningTable;
import lombok.extern.slf4j.Slf4j;


import java.util.ArrayList;
import java.util.List;
@Slf4j
public class BFSchoice {

    private Point[][] Points = new Point[144][144];  //最短距离矩阵
    private int[][] prototype = new int[6][24];  //桌椅对应二维数组 可以不要
    private int[] temp = new int[144];  //桌椅对应一维数组 用来生成Points ，计算最短距离
    private Chair[][] chairs = new Chair[6][24];

/**
 * @Description BFS
 * @Author 411头目
 * @Date 2020/5/25 21:11
 * Param [tables, peopleNumber]
 * Return java.util.List<com.exmaple.Demo.model.Chair>
 **/
    public List<Chair> BFS(List<DiningTable> tables, int peopleNumber) { //获取最终挑选好的座位，从bfsChoice 中获取所有起点的最佳策略，第一次遍历或取权值最小策略，
                                                                          // 第二次遍历或取所有与最小权值相等的策略中的最佳策略（边缘最佳）

//        System.out.println(System.currentTimeMillis());
        createChairs(tables);//创建映射表，存储椅子的位置信息（第几张桌子的第几块椅子）
        BFSChoiceResult[] bfsChoiceResults = bfsChoice(tables, peopleNumber);
//        System.out.println("length=" + bfsChoiceResults.length);
        System.out.println("bfsChoiceResults的长度:"+bfsChoiceResults.length);
        for (int i = 0; i < bfsChoiceResults.length; i++) {
            System.out.println("第"+ i +"个的总长为："+bfsChoiceResults[i].getAllLength());
        }
        int min = bfsChoiceResults[0].getAllLength();
        int index = 0;
        for (int i = 0; i < bfsChoiceResults.length; i++) {
            if (min > bfsChoiceResults[i].getAllLength() && bfsChoiceResults[i].getAllLength() != 0) {
                min = bfsChoiceResults[i].getAllLength();
                index = i;
            }
        }
//        List<ExcellentSit> sits = new ArrayList<>();
        int index2 = 0;  //最靠近边缘的选项
        int mini = 4000; //最大值 144*23 = 3312
        for (int i = 0; i < bfsChoiceResults.length; i++) {
            if (bfsChoiceResults[index].getAllLength() == bfsChoiceResults[i].getAllLength()) {
//                    sits.get(index2).setAllLength(bfsChoiceResults[i].getAllLength());
//                    sits.get(index2).setLocation(bfsChoiceResults[i].getLocation());
                    int left , right ,top ,bottom;
                    left = right = top = bottom = 0;
                for (int i1 = 0; i1 < bfsChoiceResults[i].getLocation().length; i1++) {
                    left += (bfsChoiceResults[i].getLocation()[i1]%24);
//                    right += (23-(sits.get(index2).getLocation()[i1]%24));
                    top += difference(bfsChoiceResults[i].getLocation()[i1]/24 , 0);
                }
                right = 23 * bfsChoiceResults[i].getLocation().length - left;
                bottom = 7 * bfsChoiceResults[i].getLocation().length - top;
                bottom  = bottom *3;  //高度最大值7，宽度最大值23，所以高度乘3，保证最小值不过度趋向于高度
                top = top *3;
                System.out.println("//////////////////////");
                System.out.println("right:"+right);
                System.out.println("left:"+left);
                System.out.println("top:"+top);
                System.out.println("bottom:"+bottom);
                if (mini>right){
                    mini = right;
                    index2 = i;
                }
                if(mini>left){
                    mini = left;
                    index2 = i;
                }
                if (mini>top){
                    mini = top;
                    index2 = i;
                }
                if (mini>bottom){
                    mini = bottom;
                    index2 = i;
                }
                System.out.println("mini:"+mini);

            }
        }

//        BFSChoiceResult[] same = new BFSChoiceResult[bfsChoiceResults.length];
//        for (BFSChoiceResult result : same) {
//
//        }
            index = index2;
            for (int i2 = 0; i2 < bfsChoiceResults[index].getLocation().length; i2++) {
                System.out.print("座位是：" + ((bfsChoiceResults[index].getLocation()[i2] / 24) + 1) + "-" + ((bfsChoiceResults[index].getLocation()[i2] % 24) + 1));
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

    public BFSChoiceResult[] bfsChoice(List<DiningTable> tables, int peopleNumber) { //获取以任意空位置为起点的最佳策略（返回结果中包含了位置信息和总权值）
        this.createMatrix();
       /* recommendSit和tempInFun2 的区别：
        recommendSit中的数据除了起点以外都是从tempInFun2 中取的，tempInFun2 中存放预选数据，
        每次挑选tempInFun2 中权值最小的座位给recommendSit，使得recommendSit中的总权值最小。*/
        RecommendSit[] recommendSit = new RecommendSit[peopleNumber];//存放单次策略的推荐位置
        for (int i = 0; i < peopleNumber; i++) { //初始化recommendSit
            recommendSit[i] = new RecommendSit();
        }
//        recommendSit[0].setSitNumber(5);
//        System.out.println(recommendSit[0].getSitNumber());
        BFSChoiceResult[] result = new BFSChoiceResult[144]; //存放总推荐位置 ， 144 表示可以以144个位置为起点
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
        for (int i = 0; i < 144; i++) {  // 选择起点 一次从 1 到 144
//            System.out.println("----------------------------第"+i+"个-----------------------------");
            if (temp[i] != 0) {  //非空座位不能座位起点
                for (int l = 0; l < peopleNumber - 1; l++) {//重置tempInFun2，防止数据复用
                    for (int m = 0; m < peopleNumber - 1; m++) {
                        tempInFun2[l][m].setUse(true);
                        tempInFun2[l][m].setSitNumber(0);
                        tempInFun2[l][m].setDistance(999999); //防止点数过少使得出现空余点距离为0，反复使用 值太小会有Bug 值一定要大！！！！！！！
                    }
                }

                for (int j = 0; j < peopleNumber; j++) {//重置recommentSit，防止数据复用
                    recommendSit[j].setDistance(0);
                    recommendSit[j].setSitNumber(0);
                    recommendSit[j].setUse(true);//true 表示可用
                }
                recommendSit[0].setSitNumber(i);//第一个点
                recommendSit[0].setDistance(0);
                result[result_index].setAllLength(0);
                result[result_index].location[0] = i;
                int star = i;  //新的起点
                for (int k = 1; k < peopleNumber; k++) {
                    for (int m = 0; m < 144; m++) { //（可以改进）tempInFun1每次重置，只要采用累加的方式也可以不重置
                        tempInFun1[m].setDistance(0);
                        tempInFun1[m].setLocation(m);
                    }
                    for (int j = 0; j < 144; j++) {   //该点总长赋值
//                        tempInFun1[j].setDistance(Points[star][j].getDistance());
                        for (int l = 0; l < k ; l++) {   //改动11111111111111111111111111
                            if (recommendSit[l].getSitNumber() == j) { //该点是否已经选择过 ，是则置零，表示找不到并退出
                                tempInFun1[j].setDistance(0);
                                break;
                            } else {
                                tempInFun1[j].setDistance(tempInFun1[j].getDistance() + Points[j][recommendSit[l].getSitNumber()].getDistance());
                            }
                        }
                    }
                   // tempInFun1[recommendSit[k - 1].getSitNumber()].setDistance(0); // ????????????????改动11111111111111
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
                            if (index ==( peopleNumber - k))
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
                    System.out.println("Distance:"+recommendSit[j].getDistance());
                    System.out.println("before:"+result[result_index].getAllLength());
                    result[result_index].setAllLength(recommendSit[j].getDistance() + result[result_index].getAllLength());
                    System.out.println("after:"+result[result_index].getAllLength());
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


  //   创建最短路径矩阵Point[][] Points = new Point[144][144]，
 //   通过两个座位在数组中的横向差和纵向差计算最短路径 Points[i][j].setDistance((difference(j / 24, i / 24)) + (j % 24 - i % 24));
    public void toCharArray(List<DiningTable> tables) {

        int size = tables.size();
        int k = -2;

        for (int i = 0; i < size; i++) {  //创建prototype 座位矩阵
            if (i % 8 == 0) k += 2;  // 0 和 1 为第一排桌子 ，2 和 3 为第二排 ，4 和 5 第三排
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
            if (temp[i] != 0) { //就是temp[i] == 1 即第i个位置为空 ， 可以坐人
                for (int j = i; j < 144; j++) {
                    if (i != j && temp[j] != 0)
                        if (j % 24 > i % 24)  // j 虽然一定大于 i ，也就是 j 一定在 i 的下面 ，
                                              // 但有可能是左下角 也有可能是右下角 ，添加判断是为了防止出现负值
                            Points[i][j].setDistance((difference(j / 24, i / 24)) + (j % 24 - i % 24)); //横向差值 加上纵向差值 注意 横向差值的正负
                        else
                            //difference 设置桌子行间隔
                            Points[i][j].setDistance((difference(j / 24, i / 24)) + (i % 24 - j % 24));

                    else
                        Points[i][j].setDistance(0); //表示 自身到自身的距离为 0
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
        for (int i = 0; i < 144; i++) {
            for (int j = 0; j < 144; j++) {
                if (i<j){
                    Points[i][j] = Points[j][i];
                }
                System.out.printf("%5d + %4d", Points[i][j].getDistance(), Points[i][j].getLocation());
            }
            System.out.println();
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

    public int difference(int j, int i) {   //控制桌子的行间距为 2
        int res = 0;
        if (j - i == 1) {
            if (i % 2 == 0) res = 1;   // j  一定大于 i  上三角矩阵列值一定大于行值
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
