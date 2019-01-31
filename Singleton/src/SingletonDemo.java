public class SingletonDemo {
   public static void main(String[] args) {

      //illegal construct
      //Compiler Error: The constructor SingleObject() is not visible
      //SingleObject object = new SingleObject();

      //Get the only object available
      SingleObject object = SingleObject.getInstance();

      //show the message
      object.showMessage();
   }
}