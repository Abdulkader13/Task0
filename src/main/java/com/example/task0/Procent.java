package com.example.task0;

public class Procent {
    private float sum;

    public Procent(float sum) {
        this.sum = sum;
    }

    public float countPr(int pr) {
        return (sum * pr) / 100;
    }

    public float countSum(float sum, float pr) {
        return sum + countPr((int) pr);
    }

    public int countSumrnd(int pr) {
        return Math.round(countSum(sum, pr));
    }
}