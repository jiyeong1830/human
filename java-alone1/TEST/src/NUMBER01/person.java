package NUMBER01;

public class person {
    // 필드(멤버 변수)
    private String name;
    private int age;
    
    // 기본 생성자
    public person() {
        this.name = "Unknown";
        this.age = 0;
    }
    
    // 매개변수가 있는 생성자
    public person(String name, int age) {
        this.name = name;
        this.age = age;
    }
    
    // getter와 setter 메소드
    public String getName() {
        return name;
    }
    
    public void setName(String name) {
        this.name = name;
    }
    
    public int getAge() {
        return age;
    }
    
    public void setAge(int age) {
        if (age > 0) {
            this.age = age;
        }
    }
    
    // Person 클래스의 역할 설명 메소드
    public void describe() {
        System.out.println("Name: " + name + ", Age: " + age);
    }
    
    // toString 메소드 오버라이딩
    @Override
    public String toString() {
        return "Person[name=" + name + ", age=" + age + "]";
    }
    
    // 메소드 오버라이딩 예제
    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        person person = (person) obj;
        return age == person.age && name.equals(person.name);
    }
}