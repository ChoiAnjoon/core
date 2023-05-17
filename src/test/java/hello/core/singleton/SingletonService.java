package hello.core.singleton;

public class SingletonService {

    private static final SingletonService instance = new SingletonService();


    public static SingletonService getInstance() {
        return instance;
    }

    // 생성자를 private으로 만들어서 외부에서 객체를 만들지 못하게 한다.
    private SingletonService() {
    }

    public void logic() {
        System.out.println("싱클톤 객체 로직 호출");
    }

}
