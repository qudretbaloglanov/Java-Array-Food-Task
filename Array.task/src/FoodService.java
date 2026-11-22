import java.util.ArrayList;
import java.util.Scanner;

public class FoodService {
     ArrayList<Food> foods = new ArrayList<>();
     ArrayList<Food> selectedFoods = new ArrayList<>();
    public void FoodService() {
        foods.add(new Food(1, "Pizza", 12.5));
        foods.add(new Food(2, "Burger", 8.5));
        foods.add(new Food(3, "Doner", 6.0));
        foods.add(new Food(4, "Pasta", 10.0));
        foods.add(new Food(5, "Salad", 5.0));
        foods.add(new Food(6, "Kebab", 15.0));
        foods.add(new Food(7, "Sushi", 18.0));
        foods.add(new Food(8, "Sandwich", 4.5));
        System.out.println(foods);
    }
    public void showAllFoods() {
            System.out.println(foods);
    }
    public Food findFoodById(int id) {
        for (Food food : foods) {
            if (food.getId() == id) {
                return food;
            }
        }
        return null;
    }
    public void showSelectedFoods() {
        if (selectedFoods.isEmpty()) {
            System.out.println("Hələ heç bir yemək seçilməyib!");
            return;
        }
            System.out.println(foods);
    }
    public void selectFood(int id) {
        Food food = findFoodById(id);
        if (food == null) {
            System.out.println("Yanlış ID! Yemək tapılmadı.");
            return;
        }

        selectedFoods.add(food);
        System.out.println(food.getName() + " seçildi!");
    }
    public void addFood(Food food) {
        if (findFoodById(food.getId()) != null) {
            System.out.println("Bu ID artıq mövcuddur!");
            return;
        }

        foods.add(food);
        System.out.println("Yemək uğurla əlavə edildi!");
    }
    public  void foodlist(){
        Scanner sc = new Scanner(System.in);
        FoodService service = new FoodService();

        while (true) {
            System.out.println("===== FOOD LIST =====");
            System.out.println("1. Bütün yeməkləri göstər");
            System.out.println("2. ID ilə yemək tap");
            System.out.println("3. Yemək seç");
            System.out.println("4. Seçilmiş yeməkləri göstər");
            System.out.println("5. Yeni yemək əlavə et");
            System.out.println("0. Çıxış");

            System.out.print("Seçiminiz: ");
            int choice = sc.nextInt();
            switch (choice) {
                case 1:
              service.FoodService();
                    break;

                case 2:
                    System.out.print("Yeməyin ID-sini daxil edin: ");
                    int searchId = sc.nextInt();

                    Food food = service.findFoodById(searchId);

                    if (food != null) {
                        System.out.println(food);
                    } else {
                        System.out.println("Bu ID ilə yemək tapılmadı!");
                    }
                    break;

                case 3:
                    System.out.print("Seçmək istədiyiniz yeməyin ID-si: ");
                    int selectId = sc.nextInt();

                    service.selectFood(selectId);
                    break;

                case 4:
                    service.showSelectedFoods();
                    break;

                case 5:
                    System.out.print("Yeməyin ID-si: ");
                    int id = sc.nextInt();

                    sc.nextLine();

                    System.out.print("Yeməyin adı: ");
                    String name = sc.nextLine();

                    System.out.print("Yeməyin qiyməti: ");
                    double price = sc.nextDouble();

                    Food newFood = new Food(id, name, price);

                    service.addFood(newFood);
                    break;

                case 0:
                    System.out.println("Proqramdan çıxıldı!");
                    sc.close();
                    return;

                default:
                    System.out.println("Yanlış seçim!");
            }
        }
}}
