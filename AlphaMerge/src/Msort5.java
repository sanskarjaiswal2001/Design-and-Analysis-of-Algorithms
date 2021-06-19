import java.util.Scanner;
import java.util.Random;
import java.io.*;
class MergeSort {

char[] inputArr;
char[] tempMergArr;
int cnt;
int size;
void process() throws IOException {
	Scanner scanner = new Scanner(System.in);
	System.out.print("Enter the number of elements to sorted:(>5000):");
	size = scanner.nextInt();
	inputArr = new char[size];	
	tempMergArr = new char[size];
	getRandomNumbers(inputArr);
	cnt = 0;
	doMergeSort(0, inputArr.length - 1);
	PrintWriter outA = new PrintWriter(new File("mrg_asort.txt"));
		for (char i :inputArr)
			outA.print(i + " ");
		outA.close();
		System.out.println();
		System.out.println("The time complexity is ... " + cnt);
		scanner.close();
}
void getRandomNumbers(char[] inputArr) throws IOException {
	Random rand = new Random();
	char alpha; int count = 0;
	PrintWriter out = new PrintWriter(new File("Mrandom.txt"));
	while (count<size) {
		alpha = (char)('a' + rand.nextInt(26));
		inputArr[count] = alpha;
		out.print(alpha + " ");
		count++;
	}
	out.close();
System.out.println("The total alphabets generated: " + count);
}
void doMergeSort(int lowerIndex, int higherIndex) {
	if (lowerIndex<higherIndex) {
		int middle = lowerIndex + (higherIndex - lowerIndex) / 2;
		doMergeSort(lowerIndex, middle);
		doMergeSort(middle+1, higherIndex);
		mergeParts(lowerIndex, middle, higherIndex);
	}
}

void mergeParts(int lowerIndex, int middle, int higherIndex) {
	for (int i = lowerIndex; i<= higherIndex; i++)
		tempMergArr[i] = inputArr[i];
	int i = lowerIndex;
	int j = middle + 1;
	int k = lowerIndex;
	while (i<= middle&&j<= higherIndex) {
		if (tempMergArr[i] <= tempMergArr[j]) {
			inputArr[k] = tempMergArr[i];
			i++;
			cnt++;
		} else {
			inputArr[k] = tempMergArr[j];
			j++;
			cnt++;
		}
		k++;
	}
	while (i<= middle) {
		inputArr[k] = tempMergArr[i];
		k++;
		i++;
	}

	while(j<=higherIndex)
	{
		inputArr[k] = tempMergArr[j];
		k++;
		j++;
	}
	}
}
class Msort5 {
	public static void main(String args[]) throws IOException {
		MergeSort msort = new MergeSort();
		msort.process(); //call the merge sort process
	}
}