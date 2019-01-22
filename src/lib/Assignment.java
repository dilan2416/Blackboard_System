package lib;

import java.util.*;

public abstract class Assignment {
    private String name;
    private String detail;
    private String deadline;
    private String evalutionRule;
    List<String> stuSubmission = new ArrayList<>();
    Map<Student, List<String>> stuAndAssign = new HashMap<>();
    Map<Student, Integer> stuAndGrade = new HashMap<>();

    Assignment(String name, String detail, String deadline) {
        setName(name);
        setDetail(detail);
        setDeadline(deadline);
    }

    void setName(String name) {
        this.name = name;
    }

    String getName() {
        return this.name;
    }

    void setDetail(String detail) {
        this.detail = detail;
    }

    String getDetail() {
        return this.detail;
    }

    void setDeadline(String deadline) {
        this.deadline = deadline;
    }

    String getDeadline() {
        return this.deadline;
    }

    void setEvalutionRule(String evalutionRule) {
        this.evalutionRule = evalutionRule;
    }

    String getEvalutionRule() {
        return this.evalutionRule;
    }

}
