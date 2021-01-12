public class NBody{

	public static double readRadius(String universeFile){
		In in = new In(universeFile);

		in.readInt();
		double universeRadius = in.readDouble();

		return universeRadius;
	}

	public static Body[] readBodies(String universeFile){
		In in = new In(universeFile);

		int numberOfBodies = in.readInt();
		Body[] allBodies = new Body[numberOfBodies];

		in.readDouble();

		int i;
		for(i = 0; i < allBodies.length; i = i + 1){

			double xP = in.readDouble();
			double yP = in.readDouble();
			double xV = in.readDouble();
			double yV = in.readDouble();
			double m = in.readDouble();
			String img = in.readString();

			allBodies[i] = new Body(xP, yP, xV, yV, m, img);
		}

		return allBodies;
	}

	public static void main(String args[]){
		double time = Double.parseDouble(args[0]);
		double timeStep = Double.parseDouble(args[1]);
		String filename = args[2];

		double universeRadius = readRadius(filename);
		Body[] allBodies = readBodies(filename);

		String imagetodraw = "images/starfield.jpg";

		StdDraw.setScale(-universeRadius, universeRadius);
		StdDraw.clear();
		/**StdDraw.picture(0, 0, imagetodraw);*/

		StdDraw.enableDoubleBuffering();


		double startTime;
		for(startTime = 0.0; startTime < time; startTime = startTime + timeStep){
			double[] xForces = new double[allBodies.length];
			double[] yForces = new double[allBodies.length];

			int b;
			for(b = 0; b < allBodies.length; b = b + 1){
				xForces[b] = allBodies[b].calcNetForceExertedByX(allBodies);
				yForces[b] = allBodies[b].calcNetForceExertedByY(allBodies);
			}

			for(b = 0; b < allBodies.length; b = b + 1){
				allBodies[b].update(timeStep, xForces[b], yForces[b]);
			}

			StdDraw.picture(0, 0, imagetodraw);

			for(Body b0dy : allBodies){
				b0dy.draw();
			}

			StdDraw.show();
			StdDraw.pause(10);
		}

		StdOut.printf("%d\n", allBodies.length);
		StdOut.printf("%.2e\n", universeRadius);
		for (int i = 0; i < allBodies.length; i++) {
    		StdOut.printf("%11.4e %11.4e %11.4e %11.4e %11.4e %12s\n",
            	allBodies[i].xxPos, allBodies[i].yyPos, allBodies[i].xxVel,
            	allBodies[i].yyVel, allBodies[i].mass, allBodies[i].imgFileName);   
		}

	}
}