package capstone.videochat;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;

@SpringBootTest
class VideoChatApplicationTests {


	@Autowired
	private MongoTemplate mongoTemplate;

	@Test
	void contextLoads() {
	}


	@Test
	void create() {

		Member member1 = new Member();

		member1.setId("2");
		member1.setPw("2222");
		member1.setName("권윤환");
		member1.setDepartment("소프트웨어공학과");
		member1.setStudentId("16011679");

		mongoTemplate.insert(member1);
	}

	@Test
	void read() {
		List<Member> memberList = mongoTemplate.findAll(Member.class);
		for(Member member:memberList){
			System.out.println(member.toString());
		}
	}

	@Document(collection = "member")
	static class Member{

		@Id
		private String id;
		private String pw;
		private String name;
		private String department;
		private String studentId;

		public String getId() {
			return id;
		}

		public void setId(String id) {
			this.id = id;
		}

		public String getPw() {
			return pw;
		}

		public void setPw(String pw) {
			this.pw = pw;
		}

		public String getName() {
			return name;
		}

		public void setName(String name) {
			this.name = name;
		}

		public String getDepartment() {
			return department;
		}

		public void setDepartment(String department) {
			this.department = department;
		}

		public String getStudentId() {
			return studentId;
		}

		public void setStudentId(String studentId) {
			this.studentId = studentId;
		}

		@Override
		public String toString() {
			return "Member{" +
					"id='" + id + '\'' +
					", pw='" + pw + '\'' +
					", name='" + name + '\'' +
					", department='" + department + '\'' +
					", studentId='" + studentId + '\'' +
					'}';
		}
	}
}
