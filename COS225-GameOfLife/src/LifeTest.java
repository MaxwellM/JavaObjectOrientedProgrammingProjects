public class LifeTest {
 public static void main (String[] args) {
  System.setProperty("java.util.Arrays.useLegacyMergeSort", "true");
  int size = 100;
  int boxLen = 6;
  int frameSize = size*6+100;
  Grid myGridFrame = new Grid(size,boxLen);
  myGridFrame.setSize(frameSize,frameSize);
  myGridFrame.setVisible(true);
 }
}