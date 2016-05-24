package com.dodevjutsu.katas.bank;

public interface Transactions {
    void record(int amount);

    Statement statement();
}
