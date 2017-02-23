import db.SqlRunner;

public class Department {
    private int id;
    private String title;

    public Department(String title) {
        this.title = title;
    }

    public int getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public void save() {
        String sql = String.format("INSERT INTO departments (title) VALUES ('%s')");
        this.id = SqlRunner.executeUpdate(sql);
        SqlRunner.closeConnection();
    }


    public static void deleteAll() {
        String sql = String.format("DELETE FROM departments;");
        SqlRunner.executeUpdate(sql);
        SqlRunner.closeConnection();
    }

    public void update() {
        String sql = String.format("UPDATE departments SET (title) = ('%s') WHERE id = %d;", this.title, this.getId());
        SqlRunner.executeUpdate(sql);
        SqlRunner.closeConnection();
    }


    public void delete() {
        String sql = String.format("DELETE FROM departments WHERE id = %d;", this.getId() );
        SqlRunner.executeUpdate(sql);
        SqlRunner.closeConnection();
    }






}