import java.util.*;

class Project {
    private String name;
    private int daysToComplete;

    public Project(String name, int daysToComplete) {
        this.name = name;
        this.daysToComplete = daysToComplete;
    }

    public String getName() {
        return name;
    }

    public int getDaysToComplete() {
        return daysToComplete;
    }
}

class Student {
    private String name;
    private List<Project> projects;

    public Student(String name, List<Project> projects) {
        this.name = name;
        this.projects = projects;
    }

    public String getName() {
        return name;
    }

    public List<Project> getProjects() {
        return projects;
    }
}

public class Main {
    public static void main(String[] args) {
        // Sample student projects
        List<Student> students = new ArrayList<>();
        students.add(new Student("Alice", Arrays.asList(
                new Project("Project 1", 10),
                new Project("Project 2", 5),
                new Project("Project 3", 7)
        )));
        students.add(new Student("Bob", Arrays.asList(
                new Project("Project 1", 8),
                new Project("Project 2", 10),
                new Project("Project 3", 12)
        )));

        // Calculate statistics
        for (Student student : students) {
            int totalDays = 0;
            int onTime = 0;
            int early = 0;
            int late = 0;
            for (Project project : student.getProjects()) {
                totalDays += project.getDaysToComplete();
                if (project.getDaysToComplete() <= 7) {
                    onTime++;
                } else if (project.getDaysToComplete() > 7) {
                    late++;
                } else {
                    early++;
                }
            }
            double averageDays = (double) totalDays / student.getProjects().size();
            System.out.println("Student: " + student.getName());
            System.out.println("On time: " + onTime);
            System.out.println("Late: " + late);
            System.out.println("Average days to complete projects: " + averageDays);
            System.out.println();
        }
    }
}
