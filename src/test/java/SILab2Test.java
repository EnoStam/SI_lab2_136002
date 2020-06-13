import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

public class SILab2Test {

    @Test
    public void test1() {
        //Testing branch 1,2,3,4,5,8
        Angle angle = new Angle(30,60,90);
        List<Angle> anglesList = new ArrayList<>();
        anglesList.add(angle);
        try {
            SILab2.function(anglesList);
        } catch (Exception e){
            assertEquals(e.getMessage(),"The minutes of the angle are not valid!");
        }
    }

    @Test
    public void test2() {
        //Testing branch 1,2,3,4,5,9,10
        Angle angle = new Angle(30,40,90);
        List<Angle> anglesList = new ArrayList<>();
        anglesList.add(angle);
        try {
            SILab2.function(anglesList);
        } catch (Exception e){
            assertEquals(e.getMessage(),"The seconds of the angle are not valid");
        }
    }

    @Test
    public void test3() {
        //Testing branch 1,2,3,4,5,9,11,4,14
        Angle angle = new Angle(30,40,45);
        List<Angle> anglesList = new ArrayList<>();
        List<Integer> result = new ArrayList<>();
        anglesList.add(angle);
        result = SILab2.function(anglesList);
        assertEquals(result.get(0).intValue(),angle.getDegrees()*3600 + angle.getMinutes()*60 + angle.getSeconds());
    }

    @Test
    public void test4() {
        //Testing branch 1,2,3,4,6,12,4,14
        Angle angle = new Angle(360,0,0);
        List<Angle> anglesList = new ArrayList<>();
        List<Integer> result = new ArrayList<>();
        anglesList.add(angle);
        result = SILab2.function(anglesList);
        assertEquals(result.get(0).intValue(),angle.getDegrees()*3600 + angle.getMinutes()*60 + angle.getSeconds());
    }

    @Test
    public void test5() {
        //Testing branch 1,2,3,4,6,13
        Angle angle = new Angle(360,40,90);
        List<Angle> anglesList = new ArrayList<>();
        anglesList.add(angle);
        try {
            SILab2.function(anglesList);
        } catch (Exception e){
            assertEquals(e.getMessage(),"The angle is greater then the maximum");
        }
    }

    @Test
    public void test6() {
        //Testing branch 1,2,3,4,7
        Angle angle = new Angle(30,40,58);
        Angle angle1 = new Angle(400,25,30);
        List<Angle> anglesList = new ArrayList<>();
        anglesList.add(angle);
        anglesList.add(angle1);
        try {
            SILab2.function(anglesList);
        } catch (Exception e){
            assertEquals(e.getMessage(),"The angle is smaller or greater then the minimum");
        }
    }

    @Test
    public void test7() {
        //PATH Test
        //Testing path 1,2,3,4,6,12,4,2,3,4,6,13
        Angle angle = new Angle(360,0,0);
        Angle angle1 = new Angle(360,25,30);
        List<Angle> anglesList = new ArrayList<>();
        anglesList.add(angle);
        anglesList.add(angle1);
        try {
            SILab2.function(anglesList);
        } catch (Exception e){
            assertEquals(e.getMessage(),"The angle is greater then the maximum");
        }
    }

    @Test
    public void test8() {
        //PATH Test
        //Testing path 1,2,3,4,5,9,11,4,2,3,4,6,12,4,2,3,4,7
        Angle angle = new Angle(270,20,3);
        Angle angle1 = new Angle(360,0,0);
        Angle angle2 = new Angle(400,80,100);
        List<Angle> anglesList = new ArrayList<>();
        List<Integer> result = new ArrayList<>();
        anglesList.add(angle);
        anglesList.add(angle1);
        anglesList.add(angle2);

        try {
            result = SILab2.function(anglesList);
        } catch (Exception e){
            assertEquals(e.getMessage(),"The angle is smaller or greater then the minimum");
        }
    }

    @Test
    public void test9() {
        //PATH Test
        //Testing path 1,2,3,4,5,9,11,4,2,3,4,6,12,4,14
        Angle angle = new Angle(270,20,3);
        Angle angle1 = new Angle(360,0,0);
        List<Angle> anglesList = new ArrayList<>();
        List<Integer> result = new ArrayList<>();
        anglesList.add(angle);
        anglesList.add(angle1);
        result = SILab2.function(anglesList);
        assertEquals(result.get(0).intValue(),angle.getDegrees()*3600 + angle.getMinutes()*60 + angle.getSeconds());
        assertEquals(result.get(1).intValue(),angle1.getDegrees()*3600 + angle1.getMinutes()*60 + angle1.getSeconds());
    }
}