
/* Recursive subdivision of tetrahedron to form
  3D Sierpinski gasket */


#include <stdlib.h>
#ifdef __APPLE_
#include <GLUT/glut.h>
#else
#include <GL/glut.h>
#endif
#include <math.h>

typedef float point[3];

/* initial tetrahedron */

point v[] = { {0.0, 0.0, 1.0}, {0.0, 0.942809, -0.33333},
		  {-0.816497, -0.471405, -0.333333}, {0.816497, -0.471405, -0.333333} };
GLfloat xRot = 0.0f, yRot = 0.0f, zRot = 0.0f;
GLfloat xln = 0.7f;
GLfloat yln = 0.5f;
GLfloat rsize = 1;
GLfloat xstep = 0.03f;
GLfloat ystep = 0.03f;
GLfloat myRangeWidth, myRangeHeight;
static GLfloat theta[] = { 0.0,0.0,0.0 };

int n;

void triangle(float* a, float* b, float* c)
// display one triangle using a line loop for wire frame, a single
//normal for constant shading, or three normals for interpolative shading 
{
	//	glPolygonMode(GL_FRONT_AND_BACK, GL_LINE);
	//	glBegin(GL_TRIANGLES);
	glNormal3fv(a);
	glVertex3fv(a);
	glNormal3fv(b);
	glVertex3fv(b);
	glNormal3fv(c);
	glVertex3fv(c);
	//	glEnd();
}
void normal(float* p)
{

	/* normalize a vector */

	//double sqrt();
	float d = 0.0;
	int i;
	for (i = 0; i < 3; i++) d += p[i] * p[i];
	d = sqrt(d);
	if (d > 0.0) for (i = 0; i < 3; i++) p[i] /= d;
}
void divide_triangle(point a, point b, point c, int m)
{

	// triangle subdivision using vertex numbers
	//righthand rule applied to create outward pointing faces 

	point v1, v2, v3;
	int j;


	if (m > 0)
	{
		for (j = 0; j < 3; j++) v1[j] = (a[j] + b[j]) / 2;
		normal(v1);
		for (j = 0; j < 3; j++) v2[j] = (a[j] + c[j]) / 2;
		normal(v2);
		for (j = 0; j < 3; j++) v3[j] = (b[j] + c[j]) / 2;
		normal(v3);
		divide_triangle(a, v1, v2, m - 1);
		divide_triangle(c, v2, v3, m - 1);
		divide_triangle(b, v3, v1, m - 1);
		divide_triangle(v1, v2, v3, m - 1);
	}
	else triangle(a, b, c); //draw triangle at end of recursion 
}

void keySpecialProcess(int key, int x, int y)
{
	GLfloat angle = 2.0;
	switch (key)
	{
	case GLUT_KEY_LEFT:
		xRot += angle; break;
	case GLUT_KEY_RIGHT:
		xRot -= angle; break;
	case GLUT_KEY_UP:
		yRot += angle; break;
	case GLUT_KEY_DOWN:
		yRot -= angle; break;
	case GLUT_KEY_PAGE_UP:
		zRot += angle; break;
	case GLUT_KEY_PAGE_DOWN:
		zRot -= angle; break;
	}
	if (xRot > 360) xRot -= 360.0f;
	if (xRot <= 0) xRot = 360.0f;
	if (yRot > 360) yRot -= 360.0f;
	if (yRot <= 0) yRot = 360.0f;
	if (zRot > 360) zRot -= 360.0f;
	if (zRot <= 0) zRot = 360.0f;
	glutPostRedisplay();
}

void tetrahedron(int m)
{

	// Apply triangle subdivision to faces of tetrahedron
		//glColor3f(1.0,0.0,0.0);
	divide_triangle(v[0], v[1], v[2], m);
	//	glColor3f(0.0,1.0,0.0);
	divide_triangle(v[3], v[2], v[1], m);
	//glColor3f(0.0,0.0,1.0);
	divide_triangle(v[0], v[3], v[1], m);
	//glColor3f(0.0,0.0,0.0);
	divide_triangle(v[0], v[2], v[3], m);
}
void display(void)
{

	glClear(GL_COLOR_BUFFER_BIT | GL_DEPTH_BUFFER_BIT);
	glClearColor(0.0, 0.0, 1.0, 1.0);
	//glColor3f(0.0, 0.0, 0.0);
	glEnable(GL_DEPTH_TEST);
	glPolygonMode(GL_FRONT, GL_FILL);
	glPolygonMode(GL_BACK, GL_LINE);

	glLoadIdentity();
	glPushMatrix();

	glTranslatef(xln, 0, 0);
	glTranslatef(0, yln, 0);

	glRotatef(xRot, 1.0f, 0.0f, 0.0f);
	glRotatef(yRot, 0.0f, 1.0f, 0.0f);
	glRotatef(zRot, 0.0f, 0.0f, 1.0f);

	glBegin(GL_TRIANGLES);
	tetrahedron(n);
	glEnd();
	glPopMatrix();
	glFlush();
}

void reshape(int w, int h)
{
	glViewport(0, 0, w, h);
	glMatrixMode(GL_PROJECTION);
	glLoadIdentity();
	GLfloat myRange = 3.5;
	if (w <= h) {
		myRangeWidth = myRange * (float)h / w;
		myRangeHeight = myRange;
	}
		
	else {
		myRangeWidth = myRange * (float)w / h;
		myRangeHeight = myRange;
	}
	glOrtho(-myRangeWidth, myRangeWidth, -myRangeHeight,
		myRangeHeight, -10.0, 10.0);
	glMatrixMode(GL_MODELVIEW);
	//display(); //
	glutPostRedisplay();
}

void myinit()
{
	GLfloat mat_specular[] = { 0.5, 0.5, 0.5, 1.0 };
	GLfloat mat_diffuse[] = { 0.0, 1.0, 1.0, 1.0 };
	GLfloat mat_ambient[] = { 1.0, 1.0, 1.0, 1.0 };
	GLfloat mat_shininess = { 500.0 };
	GLfloat light_ambient[] = { 0.0, 0.0, 0.0, 1.0 };
	GLfloat light_diffuse[] = { 1.0, 0.5, 0.5, 1.0 };
	GLfloat light_specular[] = { 1.0, 1.0, 1.0, 1.0 };

	/* set up ambient, diffuse, and specular components for light 0 */

	glLightfv(GL_LIGHT0, GL_AMBIENT, light_ambient);
	glLightfv(GL_LIGHT0, GL_DIFFUSE, light_diffuse);
	glLightfv(GL_LIGHT0, GL_SPECULAR, light_specular);

	/* define material properties for front face of all polygons */

	glMaterialfv(GL_FRONT, GL_SPECULAR, mat_specular);
	glMaterialfv(GL_FRONT, GL_AMBIENT, mat_ambient);
	glMaterialfv(GL_FRONT, GL_DIFFUSE, mat_diffuse);
	glMaterialf(GL_FRONT, GL_SHININESS, mat_shininess);

	glShadeModel(GL_SMOOTH); /* enable smooth shading */
	glEnable(GL_LIGHTING); /* enable lighting */
	glEnable(GL_LIGHT0);  /* enable light 0 */
	glEnable(GL_DEPTH_TEST); /* enable z buffer */
	glClearColor(1.0, 1.0, 1.0, 1.0);
	//glColor3f(0.0, 0.0, 0.0);
}

void TimerFunction(int value) {
	if (xln > myRangeWidth - rsize || xln < -myRangeWidth + rsize)
		xstep = -xstep;

	if (yln > myRangeHeight - rsize || yln < -myRangeHeight + rsize)
		ystep = -ystep;

	xRot += 2;
	yRot += 2;
	zRot += 2;
	if (xRot > 360) xRot -= 360.0f;
	if (xRot <= 0) xRot = 360.0f;
	if (yRot > 360) yRot -= 360.0f;
	if (yRot <= 0) yRot = 360.0f;
	if (zRot > 360) zRot -= 360.0f;
	if (zRot <= 0) zRot = 360.0f;

	xln += xstep;
	yln += ystep;

	glutPostRedisplay();
	glutTimerFunc(33, TimerFunction, 1);
}

void main(int argc, char** argv)
{
	n = 5;

	glutInit(&argc, argv);
	glutInitDisplayMode(GLUT_SINGLE | GLUT_RGB | GLUT_DEPTH);
	glutInitWindowSize(500, 500);
	glutCreateWindow("3D Gasket");
	myinit();
	glutReshapeFunc(reshape);
	glutDisplayFunc(display);
	glutSpecialFunc(keySpecialProcess);
	glutTimerFunc(33, TimerFunction, 1);
	glutMainLoop();
}
