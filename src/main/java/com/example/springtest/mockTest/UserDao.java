package com.example.springtest.mockTest;

import org.springframework.stereotype.Service;

@Service
public class UserDao {

    public String[] findAllUser() {

        return new String[]{"rabong", "orange"};
    }

    public Page findUsers() {
        return new Page() {
            @Override
            public int getTotalCount() {
                return 0;
            }

            @Override
            public String[] getContent() {
                return new String[0];
            }
        };
    }
}
