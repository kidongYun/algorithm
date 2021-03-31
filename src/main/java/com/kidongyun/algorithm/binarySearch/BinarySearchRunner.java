package com.kidongyun.algorithm.binarySearch;

import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

@Component
public class BinarySearchRunner implements ApplicationRunner {
    private int binarySearch(int[] data, int target) {
        int answer = -1;

        binarySearch(data, target, 0, data.length, answer);

        return answer;
    }

    private void binarySearch(int[] data, int target, int start, int end, int answer) {
        int size = end - start;
        int mid = size / 2;
        System.out.println(mid);

        if(size <= 0) {
            return;
        }

        if(target == data[mid]) {
            answer = mid;
        } else if(target < data[mid]) {
            binarySearch(data, target, start, mid, answer);
        } else {
            binarySearch(data, target, mid, end, answer);
        }
    }

    @Override
    public void run(ApplicationArguments args) {
        int[] data = new int[]{10, 20, 30, 40, 50, 60, 70, 80, 90, 100};

        binarySearch(data, 70);
    }
}
