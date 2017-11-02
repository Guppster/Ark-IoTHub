# frozen_string_literal: true

module Api
  module Entities
    class Device < Grape::Entity
      format_with(:iso_timestamp) { |dt| dt.iso8601 }
      expose :ip
      expose :account do 
        expose :address
        expose :last_transaction
        expose :history
      end

      with_options(format_with: :iso_timestamp) do
        expose :created_at
        expose :updated_at
      end
    end
  end
end
