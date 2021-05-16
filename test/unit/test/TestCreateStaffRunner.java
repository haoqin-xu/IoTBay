/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package unit.test;

import org.junit.runner.JUnitCore;
import org.junit.runner.Result;
import org.junit.runner.notification.Failure;

/**
 *
 * @author Hao-qin Xu
 */
public class TestCreateStaffRunner {
    public static void main(String[] args) {
        System.out.println("- Testing CreateStaff: ");
        Result result = JUnitCore.runClasses(CreateStaffTest.class);
        
        for (Failure failure : result.getFailures()) {
            System.out.println(failure.toString());
        }

        String status = result.wasSuccessful() ? "Passed" : "Failed";
        System.out.println(" Test status = "+status);
        System.out.println(" Number of Tests Passed = "+result.getRunCount());
        System.out.println(" Number of Tests Ignored = "+result.getIgnoreCount());
        System.out.println(" Number of Tests Failed = "+result.getFailureCount());
        System.out.println(" Time = "+result.getRunTime()/1000.0+"s");   
    }
}
