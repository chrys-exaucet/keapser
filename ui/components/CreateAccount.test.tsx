import React from "react";
import { shallow, configure, ShallowWrapper } from "enzyme";
import CreateAccount from "./CreateAccount";
import Adapter from "enzyme-adapter-react-16";

configure({ adapter: new Adapter() });

const simulateChangeOnInput = (
  wrapper: ShallowWrapper,
  inputSelector: string,
  newValue: any
) => {
  const input = wrapper.find(`[name='${inputSelector}']`);
  input.simulate("change", {
    target: {
      value: newValue,
    },
  });
  return wrapper.find(`[name='${inputSelector}']`);
};

describe("CreateAccount", () => {
  let wrapper: ShallowWrapper;
  beforeEach(() => {
    wrapper = shallow(<CreateAccount />);
  });

  it("Simulate a change on email input field", () => {
    const updatedEmailInput = simulateChangeOnInput(
      wrapper,
      "email",
      "jack@test.com"
    );
    expect(updatedEmailInput.props().value).toEqual(
      "jack@test.com"
    );
  });

  it("Simulate a change on telephone field", () => {
    const updatedTelephoneInput = simulateChangeOnInput(
      wrapper,
      "telephone",
      "+221781581008"
    );
    expect(updatedTelephoneInput.props().value).toEqual(
      "+221781581008"
    );
  });

  it("Simulate a change on first name field", () => {
    const updatedFirstNameInput = simulateChangeOnInput(
      wrapper,
      "first_name",
      "Jack Smith"
    );
    expect(updatedFirstNameInput.props().value).toEqual(
      "Jack Smith"
    );
  });

  it("Simulate a change on password field", () => {
    const updatedPasswordInput = simulateChangeOnInput(
      wrapper,
      "password",
      "jackthesmith#18"
    );
    expect(updatedPasswordInput.props().value).toEqual(
      "jackthesmith#18"
    );
  });

  it("Find the controller wrapper", () => {
    let controllerWrapper = wrapper.find(
      `[name='birthDate']`
    );
    console.log(controllerWrapper.debug());
  });

  /*it("Simulate a change on birthDate field", () => {
    const updatedBirthDateInput = simulateChangeOnInput(
      wrapper,
      "birthDate",
      "17/12/2021"
    );
    expect(updatedBirthDateInput.props().value).toEqual(
      "17/12/2021"
    );
  });*/
});
