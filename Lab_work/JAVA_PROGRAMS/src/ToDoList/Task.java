package ToDoList;

import javax.swing.text.StyledEditorKit;
import java.io.*;
import java.util.ArrayList;

public class Task {

    public ArrayList<Integer> serialNO = new ArrayList<>();
    private ArrayList<String> taskText = new ArrayList<>();
    private ArrayList<Boolean> isComplete = new ArrayList<>();

    public Task(){
        this.serialNO.clear();
        this.taskText.clear();
        this.isComplete.clear();
    }

    public Task(ArrayList<Integer> serialNO, ArrayList<String> taskText, ArrayList<Boolean> isComplete) {
        this.serialNO = serialNO;
        this.taskText = taskText;
        this.isComplete = isComplete;
    }

    public Task(Task another){
        this.serialNO = another.serialNO;
        this.taskText = another.taskText;
        this.isComplete =  another.isComplete;
    }

    public ArrayList<Integer> getSerialNO() {
        return serialNO;
    }

    public void setSerialNO(ArrayList<Integer> serialNO) {
        this.serialNO = serialNO;
    }

    public ArrayList<String> getTaskText() {
        return taskText;
    }

    public void setTaskText(ArrayList<String> taskText) {
        this.taskText = taskText;
    }

    public ArrayList<Boolean> getIsComplete() {
        return isComplete;
    }

    public void setIsComplete(ArrayList<Boolean> isComplete) {
        this.isComplete = isComplete;
    }

    public void readAndLoadTasks() {

        try (BufferedReader br = new BufferedReader(new FileReader("UserTasks.txt")))
        {
            String line;
            int i =1;
            while ((line = br.readLine()) != null) {
                String[] values = line.split("_");

                if (values.length==2){
                    serialNO.add(i);
                    taskText.add(values[0]);
                    isComplete.add(Boolean.parseBoolean(values[1]));
                }
                i++;
            }
            br.close();

        } catch (IOException e) {
            System.err.println("Error reading the file: " + e.getMessage());
        }
    }

    public void writeTaskAndLoad(String userInputTask,MainFrame frame){

        try(BufferedWriter bw = new BufferedWriter(new FileWriter("UserTasks.txt", true)))
        {
            bw.write(userInputTask + "_" + "false");
            bw.newLine();

            bw.close();
        frame.updateTaskPanel();
        } catch (IOException e) {
            System.err.println("Error writing the file: " + e.getMessage());
        }
    }

    public void updateTaskFile() {
        try (BufferedWriter bw = new BufferedWriter(new FileWriter("UserTasks.txt"))) {
            for (int i = 0; i < serialNO.size(); i++) {
                bw.write(taskText.get(i) + "_" + isComplete.get(i));
                bw.newLine();
            }
            bw.close();
        } catch (IOException e) {
            System.err.println("Error updating the file: " + e.getMessage());
        }
    }

    public ArrayList<String> viewAllTasksLoad(){
        ArrayList<String> combineValues = new ArrayList<>();
        String combining ;
        for (int i = 0; i < serialNO.size(); i++) {
            combining = String.valueOf(serialNO.get(i) + "," + taskText.get(i) + "," + isComplete.get(i));
            combineValues.add(combining);
        }
        return combineValues;
    }
    public ArrayList<String> viewAllCompletedTasksLoad(){
        ArrayList<String> combineValues = new ArrayList<>();
        String combining ;
        for (int i = 0; i < serialNO.size(); i++) {
            if (isComplete.get(i)) {
                combining = String.valueOf(serialNO.get(i) + "," + taskText.get(i) + "," + isComplete.get(i));
                combineValues.add(combining);
            }
        }
        return combineValues;
    }

}

