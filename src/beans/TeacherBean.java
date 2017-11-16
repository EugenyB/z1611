package beans;

import dao.TeacherDAO;
import tables.Teacher;

import javax.ejb.EJB;
import javax.enterprise.context.SessionScoped;
import javax.inject.Named;
import java.io.Serializable;
import java.util.List;

@Named
@SessionScoped
public class TeacherBean implements Serializable {

    @EJB
    TeacherDAO teacherDAO;

    private Teacher teacher = new Teacher();

    private boolean editMode = false;

    public Teacher getTeacher() {
        return teacher;
    }

    public void setTeacher(Teacher teacher) {
        this.teacher = teacher;
    }

    public List<Teacher> getTeachers(){
        return teacherDAO.findAll();
    }

    public void delete(int id) {
        teacherDAO.delete(id);
    }

    public void add() {
        teacherDAO.add(teacher);
        teacher = new Teacher();
    }

    public boolean isEditMode() {
        return editMode;
    }

    public void setEditMode(boolean editMode) {
        this.editMode = editMode;
    }

    public void edit(int id) {
        teacher = teacherDAO.find(id);
        editMode = true;
    }

    public void fixedit() {
        teacherDAO.fixedit(teacher);
        editMode = false;
        teacher = new Teacher();
    }
}
