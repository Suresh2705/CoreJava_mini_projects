package studentDBManagement;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeSet;

public class StudentManagementImpl implements StudentManagement {

	static Student s = new Student();
	static Map<Integer, Student> m = new LinkedHashMap<Integer, Student>();
	static List<Student> l = new ArrayList<Student>();

	@Override
	public void addStudent(Student s) {
		l.add(s);
		m.put(s.sid, s);
		Student.count++;
	}

	@Override
	public Student searchStudent(int id) {
		if (m.containsKey(id)) {
			Student result = m.get(id);
			return result;
		}
		return null;
	}

	@Override
	public List<Student> displayAllStudents() {
		return l;
	}

	@Override
	public Student removeStudent(int id) {
		if (m.containsKey(id)) {
			Student removed = m.get(id);
			m.remove(id);
			l.remove(removed);
			Student.count--;
			return removed;
		}
		return null;
	}

	@Override
	public void clearStudent() {
		m.clear();
		l.removeAll(l);
		Student.count=0;
	}

	@Override
	public Student searchHighestMark() {
		TreeSet<Student> ts = new TreeSet<Student>();
		ts.addAll(l);
		Student last = ts.last();
		return last;
	}

	@Override
	public Set<Student> sortStudent() {
		return null;
	}

	//Method Overloading
	public Set<Student> sortStudent(SortByName sortName) {
		Set<Student> ts = new TreeSet<Student>(sortName);
		ts.addAll(l);
		return ts;
	}

	public Set<Student> sortStudent(SortByAge sortAge) {
		Set<Student> ts = new TreeSet<Student>(sortAge);
		ts.addAll(l);
		return ts;
	}

}