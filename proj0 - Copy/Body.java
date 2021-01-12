public class Body{
	public double xxPos;
	public double yyPos;
	public double xxVel;
	public double yyVel;
	public double mass;
	public String imgFileName;

	public Body(double xP, double yP, double xV, double yV, double m, String img){
		this.xxPos = xP;
		this.yyPos = yP;
		this.xxVel = xV;
		this.yyVel = yV;
		this.mass = m;
		this.imgFileName = img;
	}

	public Body(Body b){
		this.xxPos = b.xxPos;
		this.yyPos = b.yyPos;
		this.xxVel = b.xxVel;
		this.yyVel = b.yyVel;
		this.mass = b.mass;
		this.imgFileName = b.imgFileName;
	}

	public double calcDistance(Body b){
		double totalDistance = Math.sqrt((Math.pow((this.xxPos - b.xxPos), 2) + Math.pow((this.yyPos - b.yyPos), 2)));
		return totalDistance;
	}

	public double calcForceExertedBy(Body b){
		double forceExerted =  (6.67e-11 * this.mass * b.mass) / Math.pow((this.calcDistance(b)), 2);
		return forceExerted;
	}

	public double calcForceExertedByX(Body b){
		double forceExertedByX = (this.calcForceExertedBy(b) * (b.xxPos - this.xxPos)) / this.calcDistance(b);
		return forceExertedByX;
	}

	public double calcForceExertedByY(Body b){
		double forceExertedByY = (this.calcForceExertedBy(b) * (b.yyPos - this.yyPos)) / this.calcDistance(b);
		return forceExertedByY;
	}




	public double calcNetForceExertedByX(Body[] allBodies){
		double netForceExertedByX = 0;

		for(Body b : allBodies){
			if (this.equals(b)){
				continue;
			}
			netForceExertedByX = netForceExertedByX + this.calcForceExertedByX(b);
		}

		return netForceExertedByX;
	}

	public double calcNetForceExertedByY(Body[] allBodies){
		double netForceExertedByY = 0;

		for(Body b : allBodies){
			if (this.equals(b)){
				continue;
			}
			netForceExertedByY = netForceExertedByY + this.calcForceExertedByY(b);
		}

		return netForceExertedByY;
	}

	public void update(double dt, double fx, double fy){
		double xxAcceleration = fx / this.mass;
		double yyAcceleration = fy / this.mass;

		this.xxVel = (this.xxVel + dt * xxAcceleration);
		this.yyVel = (this.yyVel + dt * yyAcceleration);

		this.xxPos = (this.xxPos + dt * this.xxVel);
		this.yyPos = (this.yyPos + dt * this.yyVel);
	}

	public void draw(){
		StdDraw.picture(this.xxPos, this.yyPos, "images/" + this.imgFileName);
	}




}