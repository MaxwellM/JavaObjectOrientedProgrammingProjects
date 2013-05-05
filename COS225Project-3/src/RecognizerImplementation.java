import java.util.Vector;

public class RecognizerImplementation
  implements Recognizer
{
  boolean gameState = true;
  int strCount = 0;
  int latch = 0;
  char prevChar;

  public void nextChar(char c)
  {
    this.strCount += 1;

    if (this.gameState) {
      switch (c) {
      case 'b':
        if (this.strCount == 1) {
          this.latch = 1;
        }
        else if (this.prevChar != 'a')
        {
          if ((this.latch == 1) && (this.prevChar == 'b'))
            this.gameState = false; 
        }
        break;
      case 'a':
        if (this.strCount != 1)
        {
          if (this.prevChar == 'a') {
            this.latch = 1;
          }
          else if (this.prevChar == 'b')
            this.gameState = false; 
        }
        break;
      default:
        this.gameState = false;
      }

      this.prevChar = c;
      return;
    }
  }

  public boolean isIn()
  {
    if ((this.latch == 1) && (this.prevChar == 'a'))
      this.gameState = false;
    return this.gameState;
  }

  public void reset()
  {
    this.gameState = true;
    this.strCount = 0;
    this.latch = 0;
    this.prevChar = '\000';
  }

@Override
public int A() {
	// TODO Auto-generated method stub
	return 0;
}

@Override
public int B() {
	// TODO Auto-generated method stub
	return 0;
}

@Override
public Vector<Character> test() {
	// TODO Auto-generated method stub
	return null;
}
}