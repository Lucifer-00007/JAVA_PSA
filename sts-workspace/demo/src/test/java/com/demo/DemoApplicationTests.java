package com.demo;

import org.junit.jupiter.api.*;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class DemoApplicationTests {

        @BeforeAll
        static void setUpAll() {
            // Code executed once before all test methods
            System.out.println("Before all tests");
        }

        @BeforeEach
        void setUp() {
            // Code executed before each test method
            System.out.println("Before each test");
        }

        @Test
        void add() {
        	System.out.println("add test");
        }

        @Test
        void subtract() {
        	System.out.println("sub test");
        }
       
        @AfterEach
        void tearDown() {
            // Code executed after each test method
            System.out.println("After each test");
        }

        @AfterAll
        static void tearDownAll() {
            // Code executed once after all test methods
            System.out.println("After all tests");
        }

}
