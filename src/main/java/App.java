import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class App {
    public static void main(String[] args) {
        ApplicationContext applicationContext =
                new AnnotationConfigApplicationContext(AppConfig.class);
        HelloWorld bean =
                (HelloWorld) applicationContext.getBean("helloworld");
        System.out.println(bean.getMessage());

        HelloWorld bean1 =
                (HelloWorld) applicationContext.getBean("helloworld");
        System.out.println(bean1.getMessage());
        System.out.println("Ссылаются на один объект в памяти :");
        System.out.println(bean);
        System.out.println(bean1);
        System.out.println("т.к по умолчанию у нас дефолтный scope  sinqletone итого ссылки равны ? - " + (bean == bean1));

        Cat cat = (Cat) applicationContext.getBean("catbean");
        System.out.println("\nИмя кота: " + cat.getCatName() + "\nГодиков : " + cat.getAge());

        Cat cat1 = (Cat) applicationContext.getBean("catbean");
        System.out.println("\nСсылаются на разные объекты в памяти : ");
        System.out.println(cat);
        System.out.println(cat1);
        System.out.println("т.к. scope prototype для каждого обращения создается новый бин в контейнере итого " +
                "ссылки равны ? - " + (cat == cat1));




    }
}