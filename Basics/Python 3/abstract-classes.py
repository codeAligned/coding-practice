from abc import ABCMeta, abstractmethod

class Parent(metaclass = ABCMeta):
    @abstractmethod
    def foo(self):
        pass

    @abstractmethod
    def bar(self):
        pass

class Child(Parent):
    def foo(self):
        print('Foo')

    def bar(self):
        print('Bar')

child = Child()
