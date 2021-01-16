import React from "react";
import { shallow, configure, ShallowWrapper } from "enzyme";
import CreateAccount from "../components/CreateAccount";
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
      "tel",
      "+221781581008"
    );
    expect(updatedTelephoneInput.props().value).toEqual(
      "+221781581008"
    );
  });

  it("Simulate a change on first name field", () => {
    const updatedFirstNameInput = simulateChangeOnInput(
      wrapper,
      "firstname",
      "Jack Smith"
    );
    expect(updatedFirstNameInput.props().value).toEqual(
      "Jack Smith"
    )});
    it("Simulate a change on first name field", () => {
      const updatedLastNameInput = simulateChangeOnInput(
        wrapper,
        "lastname",
        "Jack Smith"
      );
      expect(updatedLastNameInput.props().value).toEqual(
        "JENNER"
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

  it("Simulate a change on birthDate field", () => {
    const updatedBirthDayInput = simulateChangeOnInput(
      wrapper,
      "birthday",
      "17/12/2021"
    );
    expect(updatedBirthDayInput.props().value).toEqual(
      "17/12/2021"
    );
  });

  it("Simulate a change on Country", () => {
    const updatedCountryInput = simulateChangeOnInput(
      wrapper,
      "country",
      "France"
    );
    expect(updatedCountryInput.props().value).toEqual(
      "France"
    );
  });

});
