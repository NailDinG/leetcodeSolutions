import java.util.List;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Queue;

/*
 * @lc app=leetcode id=690 lang=java
 *
 * [690] Employee Importance
 */
/*
// Employee info
class Employee {
    // It's the unique id of each node;
    // unique id of this employee
    public int id;
    // the importance value of this employee
    public int importance;
    // the id of direct subordinates
    public List<Integer> subordinates;
};
*/
class Solution {
    public int getImportance(List<Employee> employees, int id) {
        if (employees == null || employees.size() == 0) {
            return 0;
        }
        HashMap<Integer, Employee> map = new HashMap<>();
        for (Employee e : employees) {
            map.put(e.id, e);
        }
        int res = 0;
        Queue<Employee> queue = new LinkedList<>();
        Employee emp = map.get(id);
        queue.add(emp);
        while (!queue.isEmpty()) {
            Employee cur = queue.poll();
            List<Integer> sub = cur.subordinates;
            res += cur.importance;
            if (sub == null || sub.size() == 0) {

            } else {
                for (Integer subId: sub) {
                    queue.add(map.get(subId));
                }
            }
        }
        return res;
    }
}

