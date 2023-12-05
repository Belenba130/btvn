import java.util.Scanner;

public class main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int input;
        int n = 0;
        Product[] products = null;

        do {
            System.out.println("Chọn chức năng");
            System.out.println("1. Nhập số sản phẩm");
            System.out.println("2. Giá sản phẩm ");
            System.out.println("3. Danh sách sản phẩm");
            System.out.println("4. Exit");
            input = sc.nextInt();
            sc.nextLine();

            switch (input) {
                case 1:
                    System.out.print("Nhập số sản phẩm: ");
                    n = sc.nextInt();
                    sc.nextLine();

                    products = new Product[n];
                    for (int i = 0; i < n; i++) {
                        Product p = new Product();
                        System.out.print("Mã sp: ");
                        p.setId(sc.nextLine());
                        System.out.print("Tên sp: ");
                        p.setName(sc.nextLine());
                        System.out.print("Giá sp: ");
                        p.setPrice(Double.parseDouble(sc.nextLine()));
                        System.out.print("Giảm giá(%): ");
                        p.setDiscount(Double.parseDouble(sc.nextLine()));
                        products[i] = p;
                    }
                    break;
                case 2:
                    if (n > 0) {
                        for (int i = 0; i < n; i++) {
                            products[i].setSalePrice(products[i].getPrice() - (products[i].getPrice() / 100 * products[i].getDiscount()));
                            System.out.println("SalePrice: " + products[i].getSalePrice());
                        }
                    } else {
                        System.out.println("Vui lòng nhập số sản phẩm trước.");
                    }
                    break;
                case 3:
                    if (n > 0) {
                        for (int i = 0; i < n; i++) {
                            System.out.println("Id: " + products[i].getId());
                            System.out.println("SalePrice: " + products[i].getSalePrice());
                            System.out.println("_____");
                        }
                    } else {
                        System.out.println("Vui lòng nhập số sản phẩm trước.");
                    }
                    break;
                case 4:
                    System.out.println("Exit");
                    break;
                default:
                    System.out.println("Vui lòng nhập lại");
            }
        } while (input != 4);

        sc.close();
    }
}
