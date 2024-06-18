package model;
import java.io.Serializable;

public class Calories implements Serializable {
    private int id;         // id
    private String user_id;     //ユーザーID
    private Double calorie;

    public Calories(int id, String user_id, Double calorie) {
		this.id = id;
		this.user_id = user_id;
		this.calorie = calorie;
	}

    public Calories(int id, Double calorie) {
		this.id = id;

		this.calorie = calorie;
	}

    public Calories(String user_id, Double calorie) {
		this.user_id = user_id;
		this.calorie = calorie;
	}

    public Calories(Double calorie) {
		this.calorie = calorie;
	}

  //引数がないコンストラクタ
    public Calories() {
		this.id = 0;
		this.user_id = "";
		this.calorie = 0.0;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getUser_id() {
		return user_id;
	}

	public void setUser_id(String user_id) {
		this.user_id = user_id;
	}

	public Double getCalorie() {
		return calorie;
	}

	public void setCalorie(Double calorie) {
		this.calorie = calorie;
	}
}
