import java.util.*;
import java.io.*;
class QSort
{
	int array[];
	int length;
	int cnt;
	int size;
	String flag;
void process() throws IOException
{
	Scanner scanner = new Scanner(System.in);
	size = scanner.nextInt();
	flag = "best"; // flag is set to true for ascending order sorting
	cnt = 0;
	int[] inputArr = new int[size];

	getRandomNumbers(inputArr);
	scanner.close();
	int tempArr[] = new int[size];
	for (int i =0; i<inputArr.length ;i++)
	tempArr[i] = inputArr[i];
	sort(inputArr);
	System.out.println();
	System.out.println("The time complexity for best case is " + cnt);
	PrintWriter outA = new PrintWriter(new File("q_asort.txt"));
	for (int i :inputArr)
		outA.print(i + " ");
	outA.close();
	cnt = 0;
	flag = "worst";
	sort(inputArr);
	System.out.println();
	System.out.println("The time complexity for worst case is " + cnt);
	cnt = 0;
	flag = "average";
	sort(tempArr);
	System.out.println();
	PrintWriter outb = new PrintWriter(new File("q_bsort.txt"));
	for (int i : inputArr) {
		outb.print(i);
		outb.print(" ");
	}
	outb.close();
	System.out.println("The time complexity for average case is " + cnt);
}
void getRandomNumbers(int[] inputArr) throws IOException
{
	Random rand = new Random();
	int number, count = 0;
	PrintWriter out = new PrintWriter(new File("Qrandom.txt"));
	while (count<size)
{
		number = rand.nextInt(size) + 1;
		out.print(number + " ");
		inputArr[count] = number;
		count++;
}
	out.close();
	System.out.println("The total numbers generated: " + count);
}
void sort(int[] inputArr)
{
	int pivot = 0;
	if (inputArr == null || inputArr.length == 0) {
		return;

}
	this.array = inputArr;
	length = inputArr.length;
	if (flag == "best" || flag == "average")
{
		pivot = array[(length) / 2];
		quickSort(0, length - 1, pivot);
}
else if (flag == "worst")
{
	pivot = array[0];
	quickSort(0, length - 1, pivot);
}
}
void quickSort(int lowerIndex, int higherIndex, int pivot)
{
	int left = lowerIndex;
	int right = higherIndex;
	switch (flag) {
	case "best":
	case "average":
		pivot = array[lowerIndex + (higherIndex - lowerIndex) / 2];
		break;
	case "worst":
		pivot = array[lowerIndex + (higherIndex - lowerIndex) / 2];
		break;
}
	while (left<= right) { // sort in ascending order
		while (array[left] <pivot) {
			left++;
			cnt++;
		}
		while (array[right] >pivot) {
			right--;
			cnt++;
		}
		if (left<= right) {
			exchangeNumbers(left, right);
			left++;
			right--;
		}
	}

	if (lowerIndex<right) {
		quickSort(lowerIndex, right, pivot);
	}
	if (left<higherIndex) {
		quickSort(left, higherIndex, pivot);
	}

}
void exchangeNumbers(int l, int r) {
	int temp = array[l];
	array[l] = array[r];
	array[r] = temp;
	}
	}
class QuickSort1 {
	public static void main(String args[]) throws IOException {
		System.out.print("Enter the number of elements to sorted: ( >5000):");
		QSort qs = new QSort();
		qs.process();
	}
}