package model;
import java.io.Serializable;

public class Users implements Serializable {
    private int id;         // id
    private String user_id;     //ユーザーID
    private String password;    //パスワード
    private String user_name;   //ユーザーネーム
    private Double height;      // 身長
    private Double weight;      //体重
    private Integer gender;     // 性別
    private Double goal_weight;     //目標体重
    private String cat;         //キャットネス

    //引数がないコンストラクタ
    public Users() {
		this.id = 0;
		this.user_id = "";
		this.password = "";
		this.user_name = "";
		this.height = 0.0;
		this.weight = 0.0;
		this.gender = 0;
		this.goal_weight = 0.0;
		this.cat = "";
	}

    //引数があるコンストラクタ
    public Users(int id, String user_id, String password, String user_name, Double height, Double weight,
            int gender, Double goal_weight, String cat) {
        super();
        this.id = id;
        this.user_id = user_id;
        this.password = password;
        this.user_name = user_name;
        this.height = height;
        this.weight = weight;
        this.gender = gender;
        this.goal_weight = goal_weight;
        this.cat = cat;
    }

    public Users(String user_id, String password) {
    	super();
    	this.user_id = user_id;
        this.password = password;
    }

    public Users(int id, String user_name, Double height, Double weight,
            int gender, Double goal_weight, String cat) {
        super();
        this.id = id;
        this.user_name = user_name;
        this.height = height;
        this.weight = weight;
        this.gender = gender;
        this.goal_weight = goal_weight;
        this.cat = cat;
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

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getUser_name() {
		return user_name;
	}

	public void setUser_name(String user_name) {
		this.user_name = user_name;
	}

	public Double getHeight() {
		return height;
	}

	public void setHeight(Double height) {
		this.height = height;
	}

	public Double getWeight() {
		return weight;
	}

	public void setWeight(Double weight) {
		this.weight = weight;
	}

	public Integer getGender() {
		return gender;
	}

	public void setGender(Integer gender) {
		this.gender = gender;
	}

	public Double getGoal_weight() {
		return goal_weight;
	}

	public void setGoal_weight(Double goal_weight) {
		this.goal_weight = goal_weight;
	}

	public String getCat() {
		return cat;
	}

	public void setCat(String cat) {
		this.cat = cat;
	}
}