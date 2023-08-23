#include <GL/glut.h>

//************车身及车轮颜色定义************
float r = 1.0, g = 1.0, b = 0.0;
float r1 = 0.0, g1 = 0.0, b1 = 0.0;
float rot1 = 0, rot2 = 0, rot3 = 0, rot4 = 0, sd = 3, fAspect;

//************ 光线及材质的定义**************

GLfloat light_ambient[] = { 0.0, 0.0, 0.0, 1.0 };
GLfloat light_diffuse[] = { 1.0, 1.0, 1.0, 1.0 };
GLfloat light_specular[] = { 1.0, 1.0, 1.0, 1.0 };
GLfloat light_position[] = { 20.0,30.0, -15.0, 0.0 };
GLfloat mat_specular[] = { 1.0, 1.0, 1.0, 1.0 };
GLfloat mat_diffuse[] = { 1.0, 1.0, 1.0, 1.0 };
GLfloat mat_ambient[] = { 0.0,0.0,0.0,1.0 };
GLfloat mat_shininess = { 10.0 };
//0-7 left  8-15 right 16-17 middle 18-21 window
//x->z->y  由于坐标系不一致->法向量问题->导致光照失败
//GLfloat vertices[ ] [3] ={{0.4f,0.0f,-1.5f},{0.4f,0.0f,1.5f},{0.4f,0.4f,1.5f},{0.4f,0.4f,0.0f},{0.4f,0.8f,0.0f},{0.4f,0.8f,-0.4f},{0.4f,0.4f,-0.8f},{0.4f,0.4f,-1.5f},{-0.4f,0.0f,-1.5f},{-0.4f,0.0f,1.5f},{-0.4f,0.4f,1.5f},{-0.4f,0.4f,0.0f},{-0.4f,0.8f,0.0f},{-0.4f,0.8f,-0.4f},{-0.4f,0.4f,-0.8f},{-0.4f,0.4f,-1.5f},{0.4f,0.0f,0.0f},{-0.4f,0.0f,0.0f},{0.4f,0.7f,-0.4f},{0.4f,0.5f,-0.8f},{-0.4f,0.7f,-0.4f},{-0.4f,0.5f,-0.8f}};
//z->x->y 
GLfloat vertices[][3] = { {-1.5f,0.0f,0.4f},{1.5f,0.0f,0.4f},{1.5f,0.4f,0.4f},{0.0f,0.4f,0.4f},{0.0f,0.8f,0.4f},{-0.4f,0.8f,0.4f},{-0.8f,0.4f,0.4f},{-1.5f,0.4f,0.4f},{-1.5f,0.0f,-0.4f},{1.5f,0.0f,-0.4f},{1.5f,0.4f,-0.4f},{0.0f,0.4f,-0.4f},{0.0f,0.8f,-0.4f},{-0.4f,0.8f,-0.4f},{-0.8f,0.4f,-0.4f},{-1.5f,0.4f,-0.4f},{0.0f,0.0f,0.4f},{0.0f,0.0f,-0.4f},{-0.4f,0.7f,0.4f},{-0.8f,0.5f,0.4f},{-0.4f,0.7f,-0.4f},{-0.8f,0.5f,-0.4f} };

//******************定义跑道*********************
void runway()
{
	//树
	glBegin(GL_QUADS);
	glColor3f(0.5f, 0.5f, 0.2f);
	glVertex3f(-2.5f, -0.3f, 0.0f);
	glColor3f(0.5f, 0.5f, 0.2f);
	glVertex3f(-2.0f, -0.3f, 0.0f);
	glColor3f(0.5f, 0.5f, 0.2f);
	glVertex3f(-2.0f, 0.3f, 0.0f);
	glColor3f(0.5f, 0.5f, 0.2f);
	glVertex3f(-2.5f, 0.3f, 0.0f);
	glEnd();
	glBegin(GL_TRIANGLE_FAN);
	glColor3f(0.0f, 1.0f, 0.0f);
	glVertex3f(-2.9f, 0.3f, 0.0f);
	glColor3f(0.0f, 1.0f, 0.0f);
	glVertex3f(-1.6f, 0.3f, 0.0f);
	glColor3f(0.0f, 1.0f, 0.0f);
	glVertex3f(-2.3f, 2.0f, 0.0f);
	glEnd();
	glBegin(GL_QUADS);
	glColor3f(0.5f, 0.5f, 0.2f);
	glVertex3f(-2.5f, -0.3f, -10.0f);
	glColor3f(0.5f, 0.5f, 0.2f);
	glVertex3f(-2.0f, -0.3f, -10.0f);
	glColor3f(0.5f, 0.5f, 0.2f);
	glVertex3f(-2.0f, 0.3f, -10.0f);
	glColor3f(0.5f, 0.5f, 0.2f);
	glVertex3f(-2.5f, 0.3f, -10.0f);
	glEnd();
	glBegin(GL_TRIANGLE_FAN);
	glColor3f(0.0f, 1.0f, 0.0f);
	glVertex3f(-2.9f, 0.3f, -10.0f);
	glColor3f(0.0f, 1.0f, 0.0f);
	glVertex3f(-1.6f, 0.3f, -10.0f);
	glColor3f(0.0f, 1.0f, 0.0f);
	glVertex3f(-2.3f, 2.0f, -10.0f);
	glEnd();

	glBegin(GL_QUADS);
	glColor3f(0.5f, 0.5f, 0.2f);
	glVertex3f(2.5f, -0.3f, 0.0f);
	glColor3f(0.5f, 0.5f, 0.2f);
	glVertex3f(2.0f, -0.3f, 0.0f);
	glColor3f(0.5f, 0.5f, 0.2f);
	glVertex3f(2.0f, 0.3f, 0.0f);
	glColor3f(0.5f, 0.5f, 0.2f);
	glVertex3f(2.5f, 0.3f, 0.0f);
	glEnd();
	glBegin(GL_TRIANGLE_FAN);
	glColor3f(0.0f, 1.0f, 0.0f);
	glVertex3f(2.9f, 0.3f, 0.0f);
	glColor3f(0.0f, 1.0f, 0.0f);
	glVertex3f(1.6f, 0.3f, 0.0f);
	glColor3f(0.0f, 1.0f, 0.0f);
	glVertex3f(2.3f, 2.0f, 0.0f);
	glEnd();
	glBegin(GL_QUADS);
	glColor3f(0.5f, 0.5f, 0.2f);
	glVertex3f(2.5f, -0.3f, -10.0f);
	glColor3f(0.5f, 0.5f, 0.2f);
	glVertex3f(2.0f, -0.3f, -10.0f);
	glColor3f(0.5f, 0.5f, 0.2f);
	glVertex3f(2.0f, 0.3f, -10.0f);
	glColor3f(0.5f, 0.5f, 0.2f);
	glVertex3f(2.5f, 0.3f, -10.0f);
	glEnd();
	glBegin(GL_TRIANGLE_FAN);
	glColor3f(0.0f, 1.0f, 0.0f);
	glVertex3f(2.9f, 0.3f, -10.0f);
	glColor3f(0.0f, 1.0f, 0.0f);
	glVertex3f(1.6f, 0.3f, -10.0f);
	glColor3f(0.0f, 1.0f, 0.0f);
	glVertex3f(2.3f, 2.0f, -10.0f);
	glEnd();

	//田野
	glBegin(GL_QUADS);
	glColor3f(0.2f, 0.8f, 0.2f);
	glVertex3f(-3.0f, -0.3f, 100.0f);
	glColor3f(0.2f, 0.8f, 0.2f);
	glVertex3f(-1.6f, -0.3f, 100.0f);
	glColor3f(0.2f, 0.8f, 0.2f);
	glVertex3f(-1.6f, -0.3f, -100.0f);
	glColor3f(0.2f, 0.8f, 0.2f);
	glVertex3f(-3.0f, -0.3f, -100.0f);
	glEnd();

	glBegin(GL_QUADS);
	glColor3f(0.2f, 0.8f, 0.2f);
	glVertex3f(1.6f, -0.3f, 100.0f);
	glColor3f(0.2f, 0.8f, 0.2f);
	glVertex3f(3.0f, -0.3f, 100.0f);
	glColor3f(0.2f, 0.8f, 0.2f);
	glVertex3f(3.0f, -0.3f, -100.0f);
	glColor3f(0.2f, 0.8f, 0.2f);
	glVertex3f(1.6f, -0.3f, -100.0f);
	glEnd();



	glBegin(GL_QUADS);
	glColor3f(0.9f, 1.0f, 0.9f);
	glVertex3f(-1.6f, -0.3f, 100.0f);
	glColor3f(0.9f, 1.0f, 0.9f);
	glVertex3f(1.6f, -0.3f, 100.0f);
	glColor3f(0.9f, 1.0f, 0.9f);
	glVertex3f(1.6f, -0.3f, -100.0f);
	glColor3f(0.9f, 1.0f, 0.9f);
	glVertex3f(-1.6f, -0.3f, -100.0f);
	glEnd();

	//天空
	glBegin(GL_QUADS);
	glColor3f(0.1f, 0.8f, 1.0f);
	glVertex3f(-25.0f, 10.0f, 100.0f);
	glColor3f(0.1f, 0.8f, 1.0f);
	glVertex3f(25.0f, 10.0f, 100.0f);
	glColor3f(0.1f, 0.8f, 1.0f);
	glVertex3f(1.6f, -0.3f, -100.0f);
	glColor3f(0.1f, 0.8f, 1.0f);
	glVertex3f(-1.6f, -0.3f, -100.0f);
	glEnd();

	//太阳
	GLfloat position[] = { 0.0, 0.0, 1.5, 1.0 };

	glPushMatrix();

	gluLookAt(0.0, 0.0, 5.0, -6.0, -6.0, -5.0, 0.0, 1.0, 0.0);

	glLightfv(GL_LIGHT0, GL_POSITION, position);
	glColor3f(1.0, 1.0, 1.0);

	glColor3f(1.0, 0.2, 0.0);
	glutSolidSphere(0.5, 50, 50);

	glPushMatrix();
	glRotated((GLdouble)0.0, 1.0, 0.0, 0.0);
	glRotated((GLdouble)0.0, 1.0, 0.0, 0.0);
	glRotated((GLdouble)0.0, 0.0, 1.0, 0.0);
	glTranslated(0.0, 0.0, 1.5);


	glPopMatrix();

	glPopMatrix();
	glFlush();


}


//*************画车身**************

void quad(int a, int b, int c, int d)
{
	glBegin(GL_QUADS);

	glVertex3fv(vertices[a]);

	glVertex3fv(vertices[b]);

	glVertex3fv(vertices[c]);

	glVertex3fv(vertices[d]);

	glEnd();

}

void car_body()
{
	glColor3f(r, g, b);
	glPushMatrix();
	glRotatef(-90.0, 0.0, 1.0, 0.0);

	glNormal3f(0.0f, -1.0f, 0.0f);//buttom
	quad(0, 1, 9, 8);



	glNormal3f(1.0f, 0.0f, 0.0f);//left
	quad(0, 1, 2, 7);
	quad(3, 4, 5, 6);


	glNormal3f(0.0f, 0.0f, -1.0f);//back
	quad(1, 2, 10, 9);
	quad(4, 3, 11, 12);
	quad(3, 11, 17, 16);


	glNormal3f(-1.0f, 0.0f, 0.0f);//right
	quad(8, 9, 10, 15);
	quad(11, 12, 13, 14);

	glNormal3f(0.0f, 0.0f, 1.0f);//front
	quad(0, 7, 15, 8);



	glNormal3f(0.0f, 1.0f, 0.0f);//top
	quad(7, 6, 14, 15);
	quad(6, 5, 13, 14);
	quad(5, 4, 12, 13);

	glColor3f(1.0, 1.0, 1.0);//window
	//quad(19,18,20,21);
	glBegin(GL_QUADS);

	glVertex3f(-0.71f, 0.5f, 0.4f);

	glVertex3f(-0.5f, 0.7f, 0.4f);

	glVertex3f(-0.5f, 0.7f, -0.4f);

	glVertex3f(-0.71f, 0.5f, -0.4f);

	glEnd();

	glPopMatrix();

}

//***************画车轮*****************

void car_wheel()
{
	GLUquadricObj* quadratic;
	glColor3f(r1, g1, b1);
	glPushMatrix();
	quadratic = gluNewQuadric();
	glTranslatef(0.2, 0, 0.7);
	glRotatef(90.0, 0, 1.0, 0);
	glTranslatef(-0.2, 0, -0.7);
	glPushMatrix();
	glRotatef(rot1, 0.0, 0.0, 1.0);
	gluCylinder(quadratic, 0.25f, 0.25f, 0.2f, 32, 32);
	glTranslatef(0.0, 0, 0.06);
	glutWireTorus(0.08, 0.25, 15, 25);
	//glutSolidTorus(0.08, 0.25, 15, 25);
	glPopMatrix();
	glTranslatef(0.0, 0, 0.8);
	glPushMatrix();
	glRotatef(rot2, 0.0, 0.0, 1.0);
	gluCylinder(quadratic, 0.25f, 0.25f, 0.2f, 32, 32);
	glTranslatef(0.0, 0, 0.13);
	glutWireTorus(0.08, 0.25, 15, 25);
	// glutSolidTorus(0.08, 0.25, 15, 25);
	glPopMatrix();
	glTranslatef(2.0, 0, -0.8);
	glPushMatrix();
	glRotatef(rot3, 0.0, 0.0, 1.0);
	gluCylinder(quadratic, 0.25f, 0.25f, 0.2f, 32, 32);
	glTranslatef(0.0, 0, 0.06);
	glutWireTorus(0.08, 0.25, 15, 25);
	// glutSolidTorus(0.08, 0.25, 15, 25);
	glPopMatrix();
	glTranslatef(0, 0, 0.8);
	glPushMatrix();
	glRotatef(rot4, 0.0, 0.0, 1.0);
	gluCylinder(quadratic, 0.25f, 0.25f, 0.2f, 32, 32);
	glTranslatef(0.0, 0, 0.13);
	glutWireTorus(0.08, 0.25, 15, 25);
	// glutSolidTorus(0.08, 0.25, 15, 25);
	glPopMatrix();

	glPopMatrix();

}

void car()
{
	car_body();

	car_wheel();
}

void mydisplay()
{
	glClear(GL_COLOR_BUFFER_BIT | GL_DEPTH_BUFFER_BIT);
	car();
	glPushMatrix();
	glLoadIdentity();
	runway();
	glPopMatrix();
	glutSwapBuffers();
}

void specialKeyBoard(int key, int x, int y)

{
	switch (key)
	{
	case GLUT_KEY_DOWN:
		glTranslatef(0, 0, 0.1);
		glutPostRedisplay();
		rot1 -= sd;
		if (rot1 < 0)rot1 = 0;
		rot2 -= sd;
		if (rot2 < 0)rot2 = 0;
		rot3 -= sd;
		if (rot3 < 0)rot3 = 0;
		rot4 -= sd;
		if (rot4 < 0)rot4 = 0;
		break;
	case GLUT_KEY_UP:
		glTranslatef(0, 0, -0.1);
		glutPostRedisplay();
		rot1 += sd;
		if (rot1 > 360)rot1 = 0;
		rot2 += sd;
		if (rot2 > 360)rot2 = 0;
		rot3 += sd;
		if (rot3 > 360)rot3 = 0;
		rot4 += sd;
		if (rot4 > 360)rot4 = 0;
		break;
	case GLUT_KEY_LEFT:
		glRotatef(1, 0, 1, 0);
		glutPostRedisplay();
		break;
	case GLUT_KEY_RIGHT:
		glRotatef(-1, 0, 1, 0);
		glutPostRedisplay();
		break;

	}
}

void myReshape(GLsizei w, GLsizei h)
{
	glViewport(0, 0, w, h);
	glMatrixMode(GL_PROJECTION);
	glLoadIdentity();
	fAspect = (GLfloat)w / (GLfloat)h;
	// gluPerspective(70.0, fAspect, 0.5, 100.0);
	gluPerspective(70.0, w / h, 0.5, 100.0);
	gluLookAt(0, 0.6, 3, 0, 0, 0, 0, 1, 0);
	glMatrixMode(GL_MODELVIEW);

}

void init()
{


	//glLightfv(GL_LIGHT0, GL_POSITION, light_position);
	//glLightfv(GL_LIGHT0, GL_AMBIENT, light_ambient);
	//glLightfv(GL_LIGHT0, GL_DIFFUSE, light_diffuse);
	//glLightfv(GL_LIGHT0, GL_SPECULAR, light_specular);


	//glMaterialfv(GL_FRONT, GL_SPECULAR, mat_specular);
	//glMaterialfv(GL_FRONT, GL_AMBIENT, mat_ambient);
	//glMaterialfv(GL_FRONT, GL_DIFFUSE, mat_diffuse);
	//glMaterialf(GL_FRONT, GL_SHININESS, mat_shininess);

	glShadeModel(GL_SMOOTH);
	glEnable(GL_LIGHTING);
	glEnable(GL_LIGHT0);
	glEnable(GL_DEPTH_TEST);
	glClearColor(1.0, 1.0, 1.0, 1.0);
	glEnable(GL_COLOR_MATERIAL);

}

void mouseFun(GLint button, GLint action, GLint xMouse, GLint yMouse) {
	if (button == GLUT_LEFT_BUTTON && action == GLUT_UP) {
		glPolygonMode(GL_FRONT_AND_BACK, GL_LINE);
	}
	if (button == GLUT_RIGHT_BUTTON && action == GLUT_UP) {
		glPolygonMode(GL_FRONT_AND_BACK, GL_FILL);
	}
}
int  main(int argc, char** argv)
{

	glutInit(&argc, argv);
	glutInitDisplayMode(GLUT_DOUBLE | GLUT_RGB | GLUT_DEPTH);
	glutInitWindowSize(1000, 500);
	glutInitWindowPosition(150, 150);
	glutCreateWindow("car");
	init();

	glColorMaterial(GL_FRONT, GL_DIFFUSE);
	glEnable(GL_COLOR_MATERIAL);
	glutSpecialFunc(specialKeyBoard);
	glutReshapeFunc(myReshape);
	glutDisplayFunc(mydisplay);
	glutMouseFunc(mouseFun);
	glutMainLoop();
	return 0;
}
