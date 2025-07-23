public class SimpleCalculator {

	private double _result;
	private double _x,_y;
	private String _userFirstVar,_userSecondVar;
	private char _operator;
	private boolean isFirstVar,isLastVar,isNoCalculationAndNotFirstOperator;

	public SimpleCalculator()
	{
		_userFirstVar="";
		_userSecondVar="";
		_x=0;
		_y=0;
		_result=0;
		_operator=' ';
		isFirstVar=true;
		isLastVar=false;
		isNoCalculationAndNotFirstOperator=false;
	}

	public void setOperator(char operator) {
		if(isNoCalculationAndNotFirstOperator==true)
		{
			calculate();
			continueCalculation();
		}
		_operator = operator;
		isFirstVar=false;
		isLastVar=true;
		isNoCalculationAndNotFirstOperator=true;
	}

	public void calculate() {
		if(_userFirstVar.equals(""))
			_userFirstVar="0";
		_x=Double.parseDouble(_userFirstVar);
		_y=Double.parseDouble(_userSecondVar);
		switch (_operator)
		{
		case '+':{
			_result=_x+_y;
			break;
		}
		case '-':{
			_result=_x-_y;
			break;
		}
		case '*':{
			_result=_x*_y;
			break;
		}
		case '/':{
			_result=_x/_y;
			break;
		}
		}
		isFirstVar=false;
		isLastVar=false;
		isNoCalculationAndNotFirstOperator=false;
	}

	public void clear() {
		_result=0;
		_x=0;
		_y=0;
		_userFirstVar="";
		_userSecondVar="";
		_operator=' ';
		isFirstVar=true;
		isLastVar=false;
		isNoCalculationAndNotFirstOperator=false;
	}

	public void continueCalculation()
	{
		_x=_result;
		_y=0;
		_result=0;
		isFirstVar=true;
		isLastVar=false;
		_operator=' ';
		if (_x%1==0)
			_userFirstVar=""+(int)_x;
		else
			_userFirstVar=""+_x;
		_userSecondVar="";
	}

	public double getResult() {
		return _result;
	}

	public String getTextToScreen() {
		if(isFirstVar && !isLastVar)
			return _userFirstVar;
		else if(!isFirstVar && isLastVar)
			return _userSecondVar;
		else
			if(_result % 1 == 0)
				return String.valueOf((int) _result);
			else 
				return String.valueOf(_result);
	}

	public void changeNumberSign()
	{
		if(isFirstVar && !isLastVar)
		{
			if(_userFirstVar.length() > 0 && _userFirstVar.charAt(0)=='-')
				_userFirstVar=_userFirstVar.substring(1);
			else
				_userFirstVar='-'+_userFirstVar;
		}
		else 
		{
			if(_userSecondVar.charAt(0)=='-')
				_userSecondVar=_userSecondVar.substring(1);
			else
				_userSecondVar='-'+_userSecondVar;
		}

	}

	public void setNumber(String text) {
		if(isFirstVar)
			_userFirstVar+=text;
		else
			_userSecondVar+=text;
	}

	public void setPointToNumber() {
		if(isFirstVar)
		{
			if (!_userFirstVar.contains("."))
				_userFirstVar+=".";
		}
		else
		{
			if (!_userSecondVar.contains("."))
				_userSecondVar+=".";
		}
	}	
}