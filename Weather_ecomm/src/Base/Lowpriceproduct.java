package Base;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.openqa.selenium.WebElement;

public class Lowpriceproduct {

	/* @Methodname   : getlowpriceproduct
	 * @Description  : This is common method to read lower price product matching the required keyword 
	 * @Param        : List<WebElement> MoisturizerList,List<WebElement> Moisturizerprice,List<WebElement> addcart,String Productcategory
	 * @Return       : Lowerprice item
	 * @Authorname   : Sonia Vhatkar
	 */


	public static String getlowpriceproduct(List<WebElement> itemList,List<WebElement> itemprice,List<WebElement> addcart,String Productcategory) {

		ArrayList<Integer> selectproduct= new ArrayList<Integer>();
		for (int i = 0; i < itemprice.size() ; i++) { /*for loop for everyproduct */
			String item= itemList.get(i).getText();/* extract only product name */
			String price= itemprice.get(i).getText();/*extract only price string*/
			if(item.contains(Productcategory)) { /*if productname contains aloe/almond*/
				String m1= itemprice.get(i).getText().substring(price.lastIndexOf(" "),price.length()).trim(); /* taking substring of space, extract the last 																																string i.e int  */
				int m2= Integer.parseInt(m1); /* convert string into integer*/
				selectproduct.add(m2); /* add these productsprice in newly created array which stores only aloe/almond price list*/
			}
		}

		Collections.sort(selectproduct);/*after adding products price in array sort in asc order*/

		int lowprice= selectproduct.get(0); /* sorted list of price, taking 0th index int as low price */
		String lowpriceitem = " ";

		for (int i = 0; i < itemprice.size() ; i++) { /*for loop for everyproduct */
			String price= itemprice.get(i).getText();/*extract price string*/ 
			String m1= itemprice.get(i).getText().substring(price.lastIndexOf(" "),price.length()).trim(); /*taking substring of space, extract the last string 																															i.e int  */
			int m2= Integer.parseInt(m1); /* convert string into integer*/
			if(m2==lowprice) {/*compares if extracted int matches the existing product prices*/ 
				lowpriceitem = itemList.get(i).getText(); /* if true then reads the product name*/
				addcart.get(i).click(); /* if match found then click*/
				break;
			}
		}
		return lowpriceitem ;
	}

	}


