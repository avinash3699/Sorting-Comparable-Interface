/* Problem : The program must accept the Name and the marks in three subjects(Maths, Physics, Chemistry) of N students as the input.
	     The program must sort the students based on the marks in Maths in descending order.
	     If two or more students have the same marks in Maths, then the program must sort those students based on the marks in Physics in descending order.
	     If two or more students have the same marks in Maths and Physics, then the program must sort those students based on the marks in Chemistry in descending order.
	     If two or more students have the same marks in Maths, Physics and Chemistry, then the program must sort the students based on the name in ascending order.
*/

import java.util.*;

class SortMarks implements Comparable<SortMarks>
{
    String name;
    int MathsMark, PhysicsMark, ChemistryMark;
    
    void setName(String name){
        this.name = name;
    }
    void setMathsMark(int MathsMark){
        this.MathsMark = MathsMark;
    }
    void setPhysicsMark(int PhysicsMark){
        this.PhysicsMark = PhysicsMark;
    }
    void setChemistryMark(int ChemistryMark){
        this.ChemistryMark = ChemistryMark;
    }
    
    String getName(){
        return this.name;
    }
    int getMathsMark(){
        return this.MathsMark;
    }
    int getPhysicsMark(){
        return this.PhysicsMark;
    }
    int getChemistryMark(){
        return this.ChemistryMark;
    }
    
    @Override
    public int compareTo(SortMarks other){
        int result = other.getMathsMark() - this.MathsMark;
        if(result == 0){
            int result2 = other.getPhysicsMark() - this.PhysicsMark;
            if(result2 == 0){
                int result3 = other.getChemistryMark() - this.ChemistryMark;
                if(result3 == 0){
                    return this.getName().compareTo(other.getName());
                }
                return result3;
            }
            return result2;
        }
        return result;
    }
    
}

public class Sorting_Marks {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int no_of_students = sc.nextInt();
        sc.nextLine();
        ArrayList<SortMarks> sorted_marks = new ArrayList<>();
        for(int i=0;i<no_of_students;i++){
            String s = sc.nextLine();
            String[] str_array = s.split(" ");
            SortMarks temp = new SortMarks();
            temp.setName(str_array[0]);
            temp.setMathsMark(Integer.parseInt(str_array[1]));
            temp.setPhysicsMark(Integer.parseInt(str_array[2]));
            temp.setChemistryMark(Integer.parseInt(str_array[3]));
            sorted_marks.add(temp);
        }
        
        Collections.sort(sorted_marks);
        
        for(SortMarks s : sorted_marks){
            System.out.println(s.getName() + " " + s.getMathsMark() + " " + s.getPhysicsMark() + " " + s.getChemistryMark());
        }
        
	}
}