package com.java.Leet.Pattern.MetrixTraversal;

import java.util.ArrayList;
import java.util.List;

interface BinaryMatrix {
      public int get(int row, int col);
      public List<Integer> dimensions();
};
class BinaryMatrixImpl implements BinaryMatrix{
    public int get(int row, int col) {return 0;}
    public List<Integer> dimensions() {
        List<Integer> intArray = new ArrayList<>();
        return intArray;
    }

}
// note that the BinaryMatrix implementaion is not right this is a dummy one just to avoid compilation error
// Please note the leetcode for bettern understadning
public class LC_Problem1428 {
    public int leftMostColumnWithOne(BinaryMatrix binaryMatrix) {
        List<Integer> arrList = binaryMatrix.dimensions();

        int row = arrList.get(0);
        int col = arrList.get(1);

        int startCol = col -1;
        int startRow =0;

        while(startCol >= 0 && startRow <= row-1){
            if(binaryMatrix.get(startRow,startCol) ==1){
                --startCol;
            }else{
                ++startRow;
            }
        }
        return startCol==(col -1)?-1:startCol + 1;
    }
}
