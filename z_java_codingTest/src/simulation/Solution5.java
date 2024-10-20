package simulation;

import java.util.*;
import java.lang.*;
import java.io.*;

//문제6: 바이토닉 수열
class Solution5 {
	public int main(int[] nums){
		int answer = 0;
        int n = nums.length; //배열 길이
        //peak값 인덱스 찾기
        //int[] peak = int[n] --> 안됨 peak 배열의 크기가 불확실해서 일반 배열 사용하면 안됨..
        ArrayList<Integer> peak = new ArrayList<>(); //<> 데이터 타입을 제네릭 타입으로 명시적으로 선언해주면 오류 잡기 편함 
        for (int i = 1 ; i < n -1 ; i++){
            if ( nums[i-1] < nums[i] && nums[i] > nums[i+1] ){
                peak.add(i);
            }
        }
        System.out.println("peak => " + peak);
        //오른쪽 왼쪽으로 카운트 늘리기
        for ( int x : peak ){
            int indexL = x;
            int indexR = x;
            int count = 1; //peak값도 갯수에 포함되니까 1부터

            //왼쪽 
            while( indexL-1 >= 0 && nums[indexL-1] < nums[indexL] ){
                count++;
                indexL--;
            }
            //오른쪽
            while( indexR+1 < n && nums[indexR] > nums[indexR+1] ){
                count++;
                indexR++;
            }
            answer = Math.max(answer , count);
        }
				
		return answer;	
	}

	public static void main(String[] args){
		Solution5 T = new Solution5();
		System.out.println(T.main(new int[]{1, 2, 1, 2, 3, 2, 1}));
		System.out.println(T.main(new int[]{1, 1, 2, 3, 5, 7, 4, 3, 1, 2}));
		System.out.println(T.main(new int[]{3, 2, 1, 3, 2, 4, 6, 7, 3, 1}));
		System.out.println(T.main(new int[]{1, 3, 1, 2, 1, 5, 3, 2, 1, 1}));
	}
}