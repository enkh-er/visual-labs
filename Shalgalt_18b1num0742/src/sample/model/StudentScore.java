package sample.model;
import javafx.beans.property.*;

public class StudentScore {
    private IntegerProperty studentID;
    private StringProperty firstName;
    private StringProperty lastName;
    private IntegerProperty Attendance20;
    private IntegerProperty AttendanceEG;
    private DoubleProperty AttendancePercent;
    private IntegerProperty WrittenQuiz50;
    private IntegerProperty WrittenQuizEG;
    private DoubleProperty WrittenQuizPercent;
    private IntegerProperty PraticalQuiz50;
    private IntegerProperty PraticalQuizEG;
    private DoubleProperty PraticalQuizPercent;
    private IntegerProperty Project100;
    private IntegerProperty ProjectEG;
    private DoubleProperty ProjectPercent;
    private IntegerProperty PrelimExam100;
    private IntegerProperty PrelimExamEG;
    private DoubleProperty PrelimExamPercent;

    public StudentScore() {
        this.studentID = new SimpleIntegerProperty();
        this.firstName = new SimpleStringProperty();
        this.lastName = new SimpleStringProperty();
        this.Attendance20 = new SimpleIntegerProperty();
        this.AttendanceEG = new SimpleIntegerProperty();
        this.AttendancePercent = new SimpleDoubleProperty();
        this.WrittenQuiz50 = new SimpleIntegerProperty();
        this.WrittenQuizEG = new SimpleIntegerProperty();
        this.WrittenQuizPercent = new SimpleDoubleProperty();
        this.PraticalQuiz50 = new SimpleIntegerProperty();
        this.PraticalQuizEG = new SimpleIntegerProperty();
        this.PraticalQuizPercent = new SimpleDoubleProperty();
        this.Project100 = new SimpleIntegerProperty();
        this.ProjectEG = new SimpleIntegerProperty();
        this.ProjectPercent = new SimpleDoubleProperty();
        this.PrelimExam100 = new SimpleIntegerProperty();
        this.PrelimExamEG = new SimpleIntegerProperty();
        this.PrelimExamPercent = new SimpleDoubleProperty();
    }

    public StudentScore(IntegerProperty studentID, StringProperty firstName, StringProperty lastName, IntegerProperty attendance20, IntegerProperty attendanceEG, DoubleProperty attendancePercent, IntegerProperty writtenQuiz50, IntegerProperty writtenQuizEG, DoubleProperty writtenQuizPercent, IntegerProperty praticalQuiz50, IntegerProperty praticalQuizEG, DoubleProperty praticalQuizPercent, IntegerProperty project100, IntegerProperty projectEG, DoubleProperty projectPercent, IntegerProperty prelimExam100, IntegerProperty prelimExamEG, DoubleProperty prelimExamPercent) {
        this.studentID = studentID;
        this.firstName = firstName;
        this.lastName = lastName;
        this.Attendance20 = attendance20;
        this.AttendanceEG = attendanceEG;
        this.AttendancePercent = attendancePercent;
        this.WrittenQuiz50 = writtenQuiz50;
        this.WrittenQuizEG = writtenQuizEG;
        this.WrittenQuizPercent = writtenQuizPercent;
        this.PraticalQuiz50 = praticalQuiz50;
        this.PraticalQuizEG = praticalQuizEG;
        this.PraticalQuizPercent = praticalQuizPercent;
        this.Project100 = project100;
        this.ProjectEG = projectEG;
        this.ProjectPercent = projectPercent;
        this.PrelimExam100 = prelimExam100;
        this.PrelimExamEG = prelimExamEG;
        this.PrelimExamPercent = prelimExamPercent;
    }

    public int getStudentID() {
        return studentID.get();
    }

    public IntegerProperty studentIDProperty() {
        return studentID;
    }

    public void setStudentID(int studentID) {
        this.studentID.set(studentID);
    }

    public String getFirstName() {
        return firstName.get();
    }

    public StringProperty firstNameProperty() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName.set(firstName);
    }

    public String getLastName() {
        return lastName.get();
    }

    public StringProperty lastNameProperty() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName.set(lastName);
    }

    public int getAttendance20() {
        return Attendance20.get();
    }

    public IntegerProperty attendance20Property() {
        return Attendance20;
    }

    public void setAttendance20(int attendance20) {
        this.Attendance20.set(attendance20);
    }

    public int getAttendanceEG() {
        return AttendanceEG.get();
    }

    public IntegerProperty attendanceEGProperty() {
        return AttendanceEG;
    }

    public void setAttendanceEG(int attendanceEG) {
        this.AttendanceEG.set(attendanceEG);
    }

    public double getAttendancePercent() {
        return AttendancePercent.get();
    }

    public DoubleProperty attendancePercentProperty() {
        return AttendancePercent;
    }

    public void setAttendancePercent(double attendancePercent) {
        this.AttendancePercent.set(attendancePercent);
    }

    public int getWrittenQuiz50() {
        return WrittenQuiz50.get();
    }

    public IntegerProperty writtenQuiz50Property() {
        return WrittenQuiz50;
    }

    public void setWrittenQuiz50(int writtenQuiz50) {
        this.WrittenQuiz50.set(writtenQuiz50);
    }

    public int getWrittenQuizEG() {
        return WrittenQuizEG.get();
    }

    public IntegerProperty writtenQuizEGProperty() {
        return WrittenQuizEG;
    }

    public void setWrittenQuizEG(int writtenQuizEG) {
        this.WrittenQuizEG.set(writtenQuizEG);
    }

    public double getWrittenQuizPercent() {
        return WrittenQuizPercent.get();
    }

    public DoubleProperty writtenQuizPercentProperty() {
        return WrittenQuizPercent;
    }

    public void setWrittenQuizPercent(double writtenQuizPercent) {
        this.WrittenQuizPercent.set(writtenQuizPercent);
    }

    public int getPraticalQuiz50() {
        return PraticalQuiz50.get();
    }

    public IntegerProperty praticalQuiz50Property() {
        return PraticalQuiz50;
    }

    public void setPraticalQuiz50(int praticalQuiz50) {
        this.PraticalQuiz50.set(praticalQuiz50);
    }

    public int getPraticalQuizEG() {
        return PraticalQuizEG.get();
    }

    public IntegerProperty praticalQuizEGProperty() {
        return PraticalQuizEG;
    }

    public void setPraticalQuizEG(int praticalQuizEG) {
        this.PraticalQuizEG.set(praticalQuizEG);
    }

    public double getPraticalQuizPercent() {
        return PraticalQuizPercent.get();
    }

    public DoubleProperty praticalQuizPercentProperty() {
        return PraticalQuizPercent;
    }

    public void setPraticalQuizPercent(double praticalQuizPercent) {
        this.PraticalQuizPercent.set(praticalQuizPercent);
    }

    public int getProject100() {
        return Project100.get();
    }

    public IntegerProperty project100Property() {
        return Project100;
    }

    public void setProject100(int project100) {
        this.Project100.set(project100);
    }

    public int getProjectEG() {
        return ProjectEG.get();
    }

    public IntegerProperty projectEGProperty() {
        return ProjectEG;
    }

    public void setProjectEG(int projectEG) {
        this.ProjectEG.set(projectEG);
    }

    public double getProjectPercent() {
        return ProjectPercent.get();
    }

    public DoubleProperty projectPercentProperty() {
        return ProjectPercent;
    }

    public void setProjectPercent(double projectPercent) {
        this.ProjectPercent.set(projectPercent);
    }

    public int getPrelimExam100() {
        return PrelimExam100.get();
    }

    public IntegerProperty prelimExam100Property() {
        return PrelimExam100;
    }

    public void setPrelimExam100(int prelimExam100) {
        this.PrelimExam100.set(prelimExam100);
    }

    public int getPrelimExamEG() {
        return PrelimExamEG.get();
    }

    public IntegerProperty prelimExamEGProperty() {
        return PrelimExamEG;
    }

    public void setPrelimExamEG(int prelimExamEG) {
        this.PrelimExamEG.set(prelimExamEG);
    }

    public double getPrelimExamPercent() {
        return PrelimExamPercent.get();
    }

    public DoubleProperty prelimExamPercentProperty() {
        return PrelimExamPercent;
    }

    public void setPrelimExamPercent(double prelimExamPercent) {
        this.PrelimExamPercent.set(prelimExamPercent);
    }
}
